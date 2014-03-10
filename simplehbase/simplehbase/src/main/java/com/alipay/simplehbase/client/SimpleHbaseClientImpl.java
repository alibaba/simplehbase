package com.alipay.simplehbase.client;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.client.coprocessor.LongColumnInterpreter;
import org.apache.hadoop.hbase.filter.Filter;

import com.alipay.simplehbase.antlr.auto.StatementsParser.Constant2Context;
import com.alipay.simplehbase.antlr.auto.StatementsParser.DeletehqlcContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.InserthqlcContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ProgContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.RowkeyexpContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.SelectCidListContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.SelecthqlcContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.TsexpContext;
import com.alipay.simplehbase.antlr.manual.ContextUtil;
import com.alipay.simplehbase.antlr.manual.RowKeyRange;
import com.alipay.simplehbase.antlr.manual.TreeUtil;
import com.alipay.simplehbase.config.HBaseColumnSchema;
import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.hql.HBaseQuery;
import com.alipay.simplehbase.util.StringUtil;
import com.alipay.simplehbase.util.Util;

/**
 * SimpleHbaseClient default implementation.
 * 
 * @author xinzhi
 * */
public class SimpleHbaseClientImpl extends SimpleHbaseClientBase {

    @Override
    public <T> T findObject(RowKey rowKey, Class<? extends T> type) {
        return findObject(rowKey, type, (QueryExtInfo) null);
    }

    @Override
    public <T> T findObject(RowKey rowKey, Class<? extends T> type,
            QueryExtInfo queryExtInfo) {
        List<T> result = findObjectList_internal(rowKey, rowKey, type, null,
                queryExtInfo);
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }

    @Override
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type) {
        return findObjectList(startRowKey, endRowKey, type, null);
    }

    @Override
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, QueryExtInfo queryExtInfo) {
        return findObjectList_internal(startRowKey, endRowKey, type, null,
                queryExtInfo);
    }

    @Override
    public <T> T findObject(RowKey rowKey, Class<? extends T> type, String id,
            Map<String, Object> para) {
        return findObject(rowKey, type, id, para, null);

    }

    @Override
    public <T> T findObject(RowKey rowKey, Class<? extends T> type, String id,
            @Nullable Map<String, Object> para, QueryExtInfo queryExtInfo) {
        List<T> result = findObjectList(rowKey, rowKey, type, id, para,
                queryExtInfo);
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }

    @Override
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para) {
        return findObjectList(startRowKey, endRowKey, type, id, para, null);
    }

    @Override
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para, QueryExtInfo queryExtInfo) {
        HBaseQuery hbaseQuery = getHbaseTableConfig().getQueryMap().get(id);
        Util.checkNull(hbaseQuery);

        StringBuilder sb = new StringBuilder();
        Map<Object, Object> context = new HashMap<Object, Object>();
        hbaseQuery.getHqlNode().applyParaMap(para, sb, context);

        String hql = sb.toString().trim();

        if (StringUtil.isEmptyString(hql)) {
            return findObjectList_internal(startRowKey, endRowKey, type, null,
                    queryExtInfo);
        }

        ProgContext progContext = TreeUtil.parseProgContext(hql);
        Filter filter = ContextUtil.parseSelectFilter(progContext,
                hbaseTableConfig, para);

        return findObjectList_internal(startRowKey, endRowKey, type, filter,
                queryExtInfo);
    }

    private <T> List<T> findObjectList_internal(RowKey startRowKey,
            RowKey endRowKey, Class<? extends T> type, @Nullable Filter filter,
            @Nullable QueryExtInfo queryExtInfo) {
        List<List<SimpleHbaseDOResult<T>>> temResult = findObjectList_internal_mv(
                startRowKey, endRowKey, type, filter, queryExtInfo);
        if (temResult.isEmpty()) {
            return new ArrayList<T>();
        } else {
            List<T> result = new ArrayList<T>();
            for (List<SimpleHbaseDOResult<T>> list : temResult) {
                if (list.isEmpty()) {
                    continue;
                } else {
                    result.add(list.get(0).getT());
                }
            }
            return result;
        }
    }

    private <T> List<List<SimpleHbaseDOResult<T>>> findObjectList_internal_mv(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            @Nullable Filter filter, @Nullable QueryExtInfo queryExtInfo) {
        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);
        Util.checkNull(type);

        Scan scan = new Scan();
        scan.setStartRow(startRowKey.toBytes());
        scan.setStopRow(endRowKey.toBytes());
        scan.setCaching(getScanCaching());
        scan.setFilter(filter);

        long startIndex = 0L;
        long length = Long.MAX_VALUE;

        if (queryExtInfo != null) {
            if (queryExtInfo.isMaxVersionSet()) {
                scan.setMaxVersions(queryExtInfo.getMaxVersions());
            }
            if (queryExtInfo.isTimeRangeSet()) {
                try {
                    scan.setTimeRange(queryExtInfo.getMinStamp(),
                            queryExtInfo.getMaxStamp());
                } catch (IOException e) {
                    // should never happen.
                    throw new SimpleHBaseException("should never happen.", e);
                }
            }
            if (queryExtInfo.isLimitSet()) {
                startIndex = queryExtInfo.getStartIndex();
                length = queryExtInfo.getLength();
            }
        }

        applyRequestFamilyAndQualifier(type, scan);

        HTableInterface htableInterface = htableInterface();
        ResultScanner resultScanner = null;

        List<List<SimpleHbaseDOResult<T>>> resultList = new ArrayList<List<SimpleHbaseDOResult<T>>>();

        try {
            resultScanner = htableInterface.getScanner(scan);
            long ignoreCounter = startIndex;
            long resultCounter = 0L;
            Result result = null;
            while ((result = resultScanner.next()) != null) {
                if (ignoreCounter-- > 0) {
                    continue;
                }

                resultList.add(convertToSimpleHbaseDOResult(result, type));

                if (++resultCounter >= length) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new SimpleHBaseException(
                    "findObjectList. startRowKey=" + startRowKey
                            + " endRowKey=" + endRowKey + " type=" + type, e);
        } finally {
            Util.close(resultScanner);
            Util.close(htableInterface);
        }

        return resultList;
    }

    @Override
    public <T> void putObjectMV(RowKey rowKey, T t, long timestamp) {
        putObject_internal(rowKey, t, timestamp);

    }

    @Override
    public <T> void putObjectMV(RowKey rowKey, T t, Date timestamp) {
        Util.checkNull(timestamp);
        putObject_internal(rowKey, t, timestamp.getTime());
    }

    @Override
    public <T> void putObject(RowKey rowKey, T t) {
        putObject_internal(rowKey, t, null);
    }

    private <T> void putObject_internal(RowKey rowKey, T t,
            @Nullable Long timestamp) {
        Util.checkRowKey(rowKey);
        Util.checkNull(t);

        Put put = new Put(rowKey.toBytes());
        TypeInfo typeInfo = TypeInfoHolder.findTypeInfo(t.getClass());
        for (ColumnInfo columnInfo : typeInfo.getColumnInfos()) {
            byte[] value = convertPOJOFieldToBytes(t, columnInfo);
            if (timestamp == null) {
                put.add(columnInfo.familyBytes, columnInfo.qualifierBytes,
                        value);
            } else {
                put.add(columnInfo.familyBytes, columnInfo.qualifierBytes,
                        timestamp.longValue(), value);
            }

        }

        HTableInterface htableInterface = htableInterface();

        try {
            htableInterface.put(put);
        } catch (IOException e) {
            throw new SimpleHBaseException("putObject. rowkey=" + rowKey
                    + " t=" + t, e);
        } finally {
            Util.close(htableInterface);
        }
    }

    @Override
    public <T> boolean insertObject(RowKey rowKey, T t) {
        return updateObjectWithVersion(rowKey, t, null);
    }

    @Override
    public <T> boolean updateObject(RowKey rowKey, T oldT, T newT) {
        Util.checkRowKey(rowKey);
        Util.checkNull(oldT);
        Util.checkNull(newT);
        Util.checkIdentityType(oldT, newT);

        TypeInfo typeInfo = TypeInfoHolder.findTypeInfo(newT.getClass());
        checkVersioned(typeInfo);

        ColumnInfo versionedColumnInfo = typeInfo.getVersionedColumnInfo();

        Object oldVersion;
        try {
            oldVersion = versionedColumnInfo.field.get(oldT);
        } catch (Exception e) {
            throw new SimpleHBaseException("updateObject. rowKey=" + rowKey
                    + " oldT=" + oldT, e);
        }
        return updateObjectWithVersion(rowKey, newT, oldVersion);

    }

    @Override
    public <T> boolean updateObjectWithVersion(RowKey rowKey, T t,
            Object oldVersion) {
        Util.checkRowKey(rowKey);
        Util.checkNull(t);
        //not check oldVersion, oldVersion can be null.

        TypeInfo typeInfo = TypeInfoHolder.findTypeInfo(t.getClass());
        checkVersioned(typeInfo);

        Put put = new Put(rowKey.toBytes());
        for (ColumnInfo columnInfo : typeInfo.getColumnInfos()) {
            byte[] value = convertPOJOFieldToBytes(t, columnInfo);
            put.add(columnInfo.familyBytes, columnInfo.qualifierBytes, value);
        }

        ColumnInfo versionedColumnInfo = typeInfo.getVersionedColumnInfo();
        byte[] oldValueOfVersion = convertValueToBytes(oldVersion,
                versionedColumnInfo);

        HTableInterface htableInterface = htableInterface();
        boolean result = false;
        try {
            result = htableInterface.checkAndPut(rowKey.toBytes(),
                    versionedColumnInfo.familyBytes,
                    versionedColumnInfo.qualifierBytes, oldValueOfVersion, put);
        } catch (IOException e) {
            throw new SimpleHBaseException("updateObjectWithVersion. rowKey="
                    + rowKey + " t=" + t + " oldVersion=" + oldVersion, e);
        } finally {
            Util.close(htableInterface);
        }

        return result;
    }

    @Override
    public long count(RowKey startRowKey, RowKey endRowKey) {
        return count_internal(startRowKey, endRowKey, null);
    }

    @Override
    public long count(RowKey startRowKey, RowKey endRowKey, String id,
            Map<String, Object> para) {
        HBaseQuery hbaseQuery = getHbaseTableConfig().getQueryMap().get(id);
        Util.checkNull(hbaseQuery);

        StringBuilder sb = new StringBuilder();
        Map<Object, Object> context = new HashMap<Object, Object>();
        hbaseQuery.getHqlNode().applyParaMap(para, sb, context);

        String hql = sb.toString().trim();

        if (StringUtil.isEmptyString(hql)) {
            return count_internal(startRowKey, endRowKey, null);
        }

        ProgContext progContext = TreeUtil.parseProgContext(hql);
        Filter filter = ContextUtil.parseCountFilter(progContext,
                hbaseTableConfig, para);

        return count_internal(startRowKey, endRowKey, filter);

    }

    private long count_internal(RowKey startRowKey, RowKey endRowKey,
            Filter filter) {
        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);

        Scan scan = new Scan();
        scan.setStartRow(startRowKey.toBytes());
        scan.setStopRow(endRowKey.toBytes());
        scan.setCaching(getScanCaching());
        scan.setFilter(filter);
        HBaseColumnSchema hbaseColumnSchema = columnSchema();
        scan.addColumn(hbaseColumnSchema.getFamilyBytes(),
                hbaseColumnSchema.getQualifierBytes());

        LongColumnInterpreter columnInterpreter = new LongColumnInterpreter();
        AggregationClient aggregationClient = aggregationClient();
        try {
            return aggregationClient.rowCount(tableNameBytes(),
                    columnInterpreter, scan);
        } catch (Throwable t) {
            throw new SimpleHBaseException("error when count.", t);
        }
    }

    @Override
    public <T> List<SimpleHbaseDOResult<T>> findObjectMV(RowKey rowKey,
            Class<? extends T> type, QueryExtInfo queryExtInfo) {
        List<List<SimpleHbaseDOResult<T>>> listOfList = findObjectListMV(
                rowKey, rowKey, type, queryExtInfo);
        if (listOfList.isEmpty()) {
            return new ArrayList<SimpleHbaseDOResult<T>>();
        } else {
            return listOfList.get(0);
        }
    }

    @Override
    public <T> List<List<SimpleHbaseDOResult<T>>> findObjectListMV(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            QueryExtInfo queryExtInfo) {
        return findObjectList_internal_mv(startRowKey, endRowKey, type, null,
                queryExtInfo);
    }

    @Override
    public <T> List<SimpleHbaseDOResult<T>> findObjectMV(RowKey rowKey,
            Class<? extends T> type, String id, Map<String, Object> para,
            QueryExtInfo queryExtInfo) {

        List<List<SimpleHbaseDOResult<T>>> listOfList = findObjectListMV(
                rowKey, rowKey, type, id, para, queryExtInfo);
        if (listOfList.isEmpty()) {
            return new ArrayList<SimpleHbaseDOResult<T>>();
        } else {
            return listOfList.get(0);
        }
    }

    @Override
    public <T> List<List<SimpleHbaseDOResult<T>>> findObjectListMV(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            String id, Map<String, Object> para, QueryExtInfo queryExtInfo) {

        HBaseQuery hbaseQuery = getHbaseTableConfig().getQueryMap().get(id);
        Util.checkNull(hbaseQuery);

        StringBuilder sb = new StringBuilder();
        Map<Object, Object> context = new HashMap<Object, Object>();
        hbaseQuery.getHqlNode().applyParaMap(para, sb, context);

        String hql = sb.toString().trim();

        if (StringUtil.isEmptyString(hql)) {
            return findObjectList_internal_mv(startRowKey, endRowKey, type,
                    null, queryExtInfo);
        }

        ProgContext progContext = TreeUtil.parseProgContext(hql);
        Filter filter = ContextUtil.parseSelectFilter(progContext,
                hbaseTableConfig, para);

        return findObjectList_internal_mv(startRowKey, endRowKey, type, filter,
                queryExtInfo);
    }

    @Override
    public void put(String hql) {
        Util.checkEmptyString(hql);

        ProgContext progContext = TreeUtil.parseProgContext(hql);
        InserthqlcContext context = ContextUtil
                .parseInserthqlcContext(progContext);
        Util.checkNull(context);

        String tableName = context.tablename().TEXT().getText();
        checkTableName(tableName);

        List<HBaseColumnSchema> hbaseColumnSchemaList = ContextUtil
                .parseHBaseColumnSchemaList(hbaseTableConfig, context.cidList());
        List<Constant2Context> constant2ContextList = context.constant2List()
                .constant2();
        Util.check(hbaseColumnSchemaList.size() == constant2ContextList.size());

        RowkeyexpContext rowkeyexpContext = context.rowkeyexp();
        RowKey rowKey = ContextUtil.parseRowKey(rowkeyexpContext);
        Util.checkRowKey(rowKey);

        Date ts = null;
        TsexpContext tsexpContext = context.tsexp();
        if (tsexpContext != null) {
            ts = ContextUtil.parseTimeStampDate(tsexpContext);
        }

        Put put = new Put(rowKey.toBytes());
        for (int i = 0; i < hbaseColumnSchemaList.size(); i++) {
            HBaseColumnSchema hbaseColumnSchema = hbaseColumnSchemaList.get(i);
            Constant2Context constant2Context = constant2ContextList.get(i);
            Object value = ContextUtil.parseConstant(hbaseColumnSchema,
                    constant2Context);
            byte[] data = convertValueToBytes(value, hbaseColumnSchema);
            if (ts == null) {
                put.add(hbaseColumnSchema.getFamilyBytes(),
                        hbaseColumnSchema.getQualifierBytes(), data);
            } else {
                put.add(hbaseColumnSchema.getFamilyBytes(),
                        hbaseColumnSchema.getQualifierBytes(), ts.getTime(),
                        data);
            }
        }

        HTableInterface htableInterface = htableInterface();

        try {
            htableInterface.put(put);
        } catch (IOException e) {
            throw new SimpleHBaseException("put. hql=" + hql, e);
        } finally {
            Util.close(htableInterface);
        }
    }

    @Override
    public List<List<SimpleHbaseCellResult>> select(String hql) {
        Util.checkEmptyString(hql);

        SelecthqlcContext context = ContextUtil.parseSelecthqlcContext(TreeUtil
                .parseProgContext(hql));
        Util.checkNull(context);

        //tableName
        String tableName = context.tablename().TEXT().getText();
        checkTableName(tableName);

        //cid list
        SelectCidListContext selectCidListContext = context.selectCidList();
        List<HBaseColumnSchema> hbaseColumnSchemaList = ContextUtil
                .parseHBaseColumnSchemaList(hbaseTableConfig,
                        selectCidListContext);
        Util.check(!hbaseColumnSchemaList.isEmpty());

        //filter
        Filter filter = ContextUtil.parseFilter(context.wherec(),
                hbaseTableConfig);

        //rowkeys.        
        RowKeyRange rowKeyRange = ContextUtil.parseRowKeyRange(context
                .rowkeyrange());

        RowKey startRowKey = rowKeyRange.getStart();
        RowKey endRowKey = rowKeyRange.getEnd();

        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);

        //queryExtInfo
        QueryExtInfo queryExtInfo = ContextUtil.parseQueryExtInfo(context);

        //scan
        Scan scan = new Scan();
        scan.setStartRow(startRowKey.toBytes());
        scan.setStopRow(endRowKey.toBytes());
        scan.setCaching(getScanCaching());
        scan.setFilter(filter);

        long startIndex = 0L;
        long length = Long.MAX_VALUE;

        if (queryExtInfo.isMaxVersionSet()) {
            scan.setMaxVersions(queryExtInfo.getMaxVersions());
        }
        if (queryExtInfo.isTimeRangeSet()) {
            try {
                scan.setTimeRange(queryExtInfo.getMinStamp(),
                        queryExtInfo.getMaxStamp());
            } catch (IOException e) {
                // should never happen.
                throw new SimpleHBaseException("should never happen.", e);
            }
        }
        if (queryExtInfo.isLimitSet()) {
            startIndex = queryExtInfo.getStartIndex();
            length = queryExtInfo.getLength();
        }

        applyRequestFamilyAndQualifier(hbaseColumnSchemaList, scan);

        HTableInterface htableInterface = htableInterface();
        ResultScanner resultScanner = null;

        List<List<SimpleHbaseCellResult>> resultList = new ArrayList<List<SimpleHbaseCellResult>>();

        try {
            resultScanner = htableInterface.getScanner(scan);
            long ignoreCounter = startIndex;
            long resultCounter = 0L;
            Result result = null;
            while ((result = resultScanner.next()) != null) {
                if (ignoreCounter-- > 0) {
                    continue;
                }

                resultList.add(convertToSimpleHbaseCellResultList(result));

                if (++resultCounter >= length) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new SimpleHBaseException("select. hql=" + hql, e);
        } finally {
            Util.close(resultScanner);
            Util.close(htableInterface);
        }

        return resultList;
    }

    @Override
    public void deleteObject(RowKey rowKey, Class<?> type) {
        deleteObjectList(rowKey, rowKey, type);
    }

    @Override
    public void deleteObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<?> type) {
        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);
        Util.checkNull(type);

        TypeInfo typeInfo = TypeInfoHolder.findTypeInfo(type);
        List<ColumnInfo> columnInfoList = typeInfo.getColumnInfos();

        Scan scan = new Scan();
        scan.setStartRow(startRowKey.toBytes());
        scan.setStopRow(endRowKey.toBytes());
        scan.setCaching(getScanCaching());

        delete_internal(scan, columnInfoList, null, null);
    }

    @Override
    public void delete(String hql) {
        Util.checkEmptyString(hql);

        DeletehqlcContext context = ContextUtil.parseDeletehqlcContext(TreeUtil
                .parseProgContext(hql));
        Util.checkNull(context);

        //tableName
        String tableName = context.tablename().TEXT().getText();
        checkTableName(tableName);

        //cid list
        SelectCidListContext selectCidListContext = context.selectCidList();
        List<HBaseColumnSchema> hbaseColumnSchemaList = ContextUtil
                .parseHBaseColumnSchemaList(hbaseTableConfig,
                        selectCidListContext);
        Util.check(!hbaseColumnSchemaList.isEmpty());

        //filter
        Filter filter = ContextUtil.parseFilter(context.wherec(),
                hbaseTableConfig);

        //rowkeys.
        RowKeyRange rowKeyRange = ContextUtil.parseRowKeyRange(context
                .rowkeyrange());

        RowKey startRowKey = rowKeyRange.getStart();
        RowKey endRowKey = rowKeyRange.getEnd();

        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);

        Date ts = null;
        TsexpContext tsexpContext = context.tsexp();
        if (tsexpContext != null) {
            ts = ContextUtil.parseTimeStampDate(tsexpContext);
        }

        Scan scan = new Scan();
        scan.setStartRow(startRowKey.toBytes());
        scan.setStopRow(endRowKey.toBytes());
        scan.setCaching(getScanCaching());
        scan.setFilter(filter);

        delete_internal(scan, null, hbaseColumnSchemaList, ts);
    }

    private void delete_internal(Scan scan,
            @Nullable List<ColumnInfo> columnInfoList,
            @Nullable List<HBaseColumnSchema> hbaseColumnSchemaList,
            @Nullable Date ts) {

        final int deleteBatch = getDeleteBatch();

        while (true) {
            Scan temScan = null;
            try {
                temScan = new Scan(scan);
            } catch (IOException e) {
                throw new SimpleHBaseException("delete_internal. scan = "
                        + temScan, e);
            }

            List<Delete> deletes = new LinkedList<Delete>();

            HTableInterface htableInterface = htableInterface();
            ResultScanner resultScanner = null;
            try {
                resultScanner = htableInterface.getScanner(temScan);
                Result result = null;
                while ((result = resultScanner.next()) != null) {

                    Delete delete = new Delete(result.getRow());

                    if (columnInfoList != null) {
                        for (ColumnInfo columnInfo : columnInfoList) {
                            if (ts == null) {
                                delete.deleteColumns(columnInfo.familyBytes,
                                        columnInfo.qualifierBytes);
                            } else {
                                delete.deleteColumn(columnInfo.familyBytes,
                                        columnInfo.qualifierBytes, ts.getTime());
                            }
                        }
                    }

                    if (hbaseColumnSchemaList != null) {
                        for (HBaseColumnSchema hbaseColumnSchema : hbaseColumnSchemaList) {
                            if (ts == null) {
                                delete.deleteColumns(
                                        hbaseColumnSchema.getFamilyBytes(),
                                        hbaseColumnSchema.getQualifierBytes());
                            } else {
                                delete.deleteColumn(
                                        hbaseColumnSchema.getFamilyBytes(),
                                        hbaseColumnSchema.getQualifierBytes(),
                                        ts.getTime());
                            }
                        }
                    }

                    deletes.add(delete);

                    if (deletes.size() >= deleteBatch) {
                        break;
                    }
                }

            } catch (IOException e) {
                throw new SimpleHBaseException("delete_internal. scan = "
                        + temScan, e);
            } finally {
                Util.close(resultScanner);
                Util.close(htableInterface);
            }

            final int deleteListSize = deletes.size();
            if (deleteListSize == 0) {
                return;
            }

            try {
                htableInterface = htableInterface();
                htableInterface.delete(deletes);
            } catch (IOException e) {
                throw new SimpleHBaseException("delete_internal. scan = "
                        + temScan, e);
            } finally {
                Util.close(htableInterface);
            }

            //successful delete will clear the items of deletes list.
            if (deletes.size() > 0) {
                throw new SimpleHBaseException("delete_internal fail. deletes="
                        + deletes);
            }

            if (deleteListSize < deleteBatch) {
                return;
            }
        }
    }
}
