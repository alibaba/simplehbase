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

import com.alipay.simplehbase.antlr.auto.StatementsParser.ConstantContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.InsertconstantListContext;
import com.alipay.simplehbase.antlr.auto.StatementsParser.ProgContext;
import com.alipay.simplehbase.antlr.manual.ContextUtil;
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

        ProgContext progContext = TreeUtil.parse(hql);
        Filter filter = TreeUtil.parseSelectFilter(progContext,
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

        applyRequestFamily(type, scan);

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
    public void deleteObject(RowKey rowKey) {
        Util.checkRowKey(rowKey);

        HTableInterface htableInterface = htableInterface();
        Delete delete = new Delete(rowKey.toBytes());
        try {
            htableInterface.delete(delete);
        } catch (IOException e) {
            throw new SimpleHBaseException("deleteObject. rowkey=" + rowKey, e);
        } finally {
            Util.close(htableInterface);
        }
    }

    @Override
    public void deleteObjectList(RowKey startRowKey, RowKey endRowKey) {
        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);

        final int deleteBatch = getDeleteBatch();

        while (true) {

            Scan scan = new Scan();
            scan.setStartRow(startRowKey.toBytes());
            scan.setStopRow(endRowKey.toBytes());
            scan.setCaching(getScanCaching());

            List<Delete> deletes = new LinkedList<Delete>();

            HTableInterface htableInterface = htableInterface();
            ResultScanner resultScanner = null;
            try {
                resultScanner = htableInterface.getScanner(scan);
                Result result = null;
                while ((result = resultScanner.next()) != null) {
                    deletes.add(new Delete(result.getRow()));
                    if (deletes.size() >= deleteBatch) {
                        break;
                    }
                }

            } catch (IOException e) {
                throw new SimpleHBaseException("deleteObjectList. startRowKey="
                        + startRowKey + " endRowKey=" + endRowKey, e);
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
                throw new SimpleHBaseException("deleteObjectList. startRowKey="
                        + startRowKey + " endRowKey=" + endRowKey, e);
            } finally {
                Util.close(htableInterface);
            }

            //successful delete will clear the items of deletes list.
            if (deletes.size() > 0) {
                throw new SimpleHBaseException(
                        "deleteObjectList fail. deletes=" + deletes);
            }

            if (deleteListSize < deleteBatch) {
                return;
            }
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

        ProgContext progContext = TreeUtil.parse(hql);
        Filter filter = TreeUtil.parseCountFilter(progContext,
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

        ProgContext progContext = TreeUtil.parse(hql);
        Filter filter = TreeUtil.parseSelectFilter(progContext,
                hbaseTableConfig, para);

        return findObjectList_internal_mv(startRowKey, endRowKey, type, filter,
                queryExtInfo);
    }

    @Override
    public void put(String hql) {
        Util.checkEmptyString(hql);

        ProgContext progContext = TreeUtil.parse(hql);
        InsertconstantListContext context = TreeUtil
                .parseInsertconstantListContext(progContext);
        Util.checkNull(context);

        String tableName = context.tablename().TEXT().getText();
        checkTableName(tableName);

        List<HBaseColumnSchema> hbaseColumnSchemaList = ContextUtil
                .parseHBaseColumnSchemaList(hbaseTableConfig, context.cidList());
        List<ConstantContext> constantContextList = context.constantList()
                .constant();

        Util.check(hbaseColumnSchemaList.size() == constantContextList.size());

        // TODO Auto-generated method stub

    }

}
