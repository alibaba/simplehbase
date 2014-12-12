package com.alipay.simplehbase.client;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.client.coprocessor.LongColumnInterpreter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.FilterList.Operator;
import org.apache.hadoop.hbase.filter.PageFilter;

import allen.hbase.cp.ext.aggr.AggrHandler;
import allen.hbase.cp.ext.aggr.AggrReducer;
import allen.hbase.cp.ext.aggr.AggrRequest;
import allen.hbase.cp.ext.aggr.AggrResult;
import allen.hbase.cp.ext2.CpClient2;

import com.alipay.simplehbase.antlr.auto.StatementsParser.Constant2Context;
import com.alipay.simplehbase.antlr.auto.StatementsParser.CountsumclContext;
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
import com.alipay.simplehbase.client.rowkey.BytesRowKey;
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
        return unwrap(findObjectAndKey(rowKey, type));
    }

    @Override
    public <T> T findObject(RowKey rowKey, Class<? extends T> type,
            QueryExtInfo queryExtInfo) {
        return unwrap(findObjectAndKey(rowKey, type, queryExtInfo));
    }

    @Override
    public <T> T findObject(RowKey rowKey, Class<? extends T> type, String id,
            Map<String, Object> para) {
        return unwrap(findObjectAndKey(rowKey, type, id, para));
    }

    @Override
    public <T> T findObject(RowKey rowKey, Class<? extends T> type, String id,
            @Nullable Map<String, Object> para, QueryExtInfo queryExtInfo) {
        return unwrap(findObjectAndKey(rowKey, type, id, para, queryExtInfo));
    }

    private <T> T unwrap(
            SimpleHbaseDOWithKeyResult<T> simpleHbaseDOWithKeyResult) {
        if (simpleHbaseDOWithKeyResult == null) {
            return null;
        }
        return simpleHbaseDOWithKeyResult.getT();
    }

    @Override
    public <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey(RowKey rowKey,
            Class<? extends T> type) {
        return findObjectAndKey(rowKey, type, (QueryExtInfo) null);
    }

    @Override
    public <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey(RowKey rowKey,
            Class<? extends T> type, QueryExtInfo queryExtInfo) {
        return findObjectAndKey_internal(rowKey, type, null, queryExtInfo);
    }

    @Override
    public <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey(RowKey rowKey,
            Class<? extends T> type, String id, Map<String, Object> para) {
        return findObjectAndKey(rowKey, type, id, para, null);
    }

    @Override
    public <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey(RowKey rowKey,
            Class<? extends T> type, String id, Map<String, Object> para,
            QueryExtInfo queryExtInfo) {
        Filter filter = parseSelectFilter(id, para);
        return findObjectAndKey_internal(rowKey, type, filter, queryExtInfo);
    }

    private <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey_internal(
            RowKey rowKey, Class<? extends T> type, @Nullable Filter filter,
            @Nullable QueryExtInfo queryExtInfo) {
        Util.checkRowKey(rowKey);
        Util.checkNull(type);

        HTableInterface htableInterface = htableInterface();

        try {
            Get get = constructGet(rowKey, filter);

            //only query 1 version.
            if (queryExtInfo != null) {
                queryExtInfo.setMaxVersions(1);
            }

            if (queryExtInfo != null) {
                if (queryExtInfo.isMaxVersionSet()) {
                    get.setMaxVersions(queryExtInfo.getMaxVersions());
                }
                if (queryExtInfo.isTimeRangeSet()) {
                    get.setTimeRange(queryExtInfo.getMinStamp(),
                            queryExtInfo.getMaxStamp());
                }
            }

            applyRequestFamilyAndQualifier(type, get);

            return convertToSimpleHbaseDOWithKeyResult(
                    htableInterface.get(get), type);
        } catch (IOException e) {
            throw new SimpleHBaseException("findObjectAndKey_internal. rowKey="
                    + rowKey + " type=" + type, e);
        } finally {
            Util.close(htableInterface);
        }

    }

    @Override
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type) {
        return unwrap(findObjectAndKeyList(startRowKey, endRowKey, type));
    }

    @Override
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, QueryExtInfo queryExtInfo) {
        return unwrap(findObjectAndKeyList(startRowKey, endRowKey, type,
                queryExtInfo));
    }

    @Override
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para) {
        return unwrap(findObjectAndKeyList(startRowKey, endRowKey, type, id,
                para));
    }

    @Override
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para, QueryExtInfo queryExtInfo) {
        return unwrap(findObjectAndKeyList(startRowKey, endRowKey, type, id,
                para, queryExtInfo));
    }

    private <T> List<T> unwrap(
            List<SimpleHbaseDOWithKeyResult<T>> simpleHbaseDOWithKeyResultList) {
        List<T> resultList = new ArrayList<T>();
        if (!simpleHbaseDOWithKeyResultList.isEmpty()) {
            for (SimpleHbaseDOWithKeyResult<T> t : simpleHbaseDOWithKeyResultList) {
                resultList.add(unwrap(t));
            }
        }
        return resultList;
    }

    @Override
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type) {
        return findObjectAndKeyList(startRowKey, endRowKey, type, null);
    }

    @Override
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            QueryExtInfo queryExtInfo) {
        return findObjectAndKeyList_internal(startRowKey, endRowKey, type,
                null, queryExtInfo);
    }

    @Override
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            String id, Map<String, Object> para) {
        return findObjectAndKeyList(startRowKey, endRowKey, type, id, para,
                null);
    }

    @Override
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            String id, Map<String, Object> para, QueryExtInfo queryExtInfo) {
        Filter filter = parseSelectFilter(id, para);
        return findObjectAndKeyList_internal(startRowKey, endRowKey, type,
                filter, queryExtInfo);
    }

    private <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList_internal(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            @Nullable Filter filter, @Nullable QueryExtInfo queryExtInfo) {
        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);
        Util.checkNull(type);

        Scan scan = constructScan(startRowKey, endRowKey, filter, queryExtInfo);

        //only query 1 version.
        if (queryExtInfo != null) {
            queryExtInfo.setMaxVersions(1);
        }

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

        List<SimpleHbaseDOWithKeyResult<T>> resultList = new ArrayList<SimpleHbaseDOWithKeyResult<T>>();

        try {
            resultScanner = htableInterface.getScanner(scan);
            long ignoreCounter = startIndex;
            long resultCounter = 0L;
            Result result = null;
            while ((result = resultScanner.next()) != null) {
                if (ignoreCounter-- > 0) {
                    continue;
                }

                SimpleHbaseDOWithKeyResult<T> t = convertToSimpleHbaseDOWithKeyResult(
                        result, type);
                if (t != null) {
                    resultList.add(t);
                    if (++resultCounter >= length) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new SimpleHBaseException(
                    "findObjectAndKeyList_internal. startRowKey=" + startRowKey
                            + " endRowKey=" + endRowKey + " type=" + type, e);
        } finally {
            Util.close(resultScanner);
            Util.close(htableInterface);
        }

        return resultList;
    }

    @Override
    public <T> List<T> findObjectBatch(List<RowKey> rowKeyList,
            Class<? extends T> type) {
        return unwrap(findObjectAndKeyBatch(rowKeyList, type));
    }

    @Override
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyBatch(
            List<RowKey> rowKeyList, Class<? extends T> type) {

        Util.checkRowKeyList(rowKeyList);
        Util.checkNull(type);

        HTableInterface htableInterface = htableInterface();

        try {
            List<Get> getList = new ArrayList<Get>();

            for (RowKey rowKey : rowKeyList) {
                Get get = constructGet(rowKey, null);
                applyRequestFamilyAndQualifier(type, get);
                getList.add(get);
            }

            List<SimpleHbaseDOWithKeyResult<T>> resultList = new ArrayList<SimpleHbaseDOWithKeyResult<T>>();
            Result[] hbaseResults = htableInterface.get(getList);
            for (Result hbaseResult : hbaseResults) {
                resultList.add(convertToSimpleHbaseDOWithKeyResult(hbaseResult,
                        type));
            }
            return resultList;
        } catch (IOException e) {
            throw new SimpleHBaseException("findOjectAndKeyBatch. rowKeyList="
                    + rowKeyList + " type=" + type, e);
        } finally {
            Util.close(htableInterface);
        }
    }

    @Override
    public <T> List<SimpleHbaseDOResult<T>> findObjectMV(RowKey rowKey,
            Class<? extends T> type, QueryExtInfo queryExtInfo) {
        return findObject_internal_mv(rowKey, type, null, queryExtInfo);
    }

    @Override
    public <T> List<SimpleHbaseDOResult<T>> findObjectMV(RowKey rowKey,
            Class<? extends T> type, String id, Map<String, Object> para,
            QueryExtInfo queryExtInfo) {
        Filter filter = parseSelectFilter(id, para);
        return findObject_internal_mv(rowKey, type, filter, queryExtInfo);
    }

    private <T> List<SimpleHbaseDOResult<T>> findObject_internal_mv(
            RowKey rowKey, Class<? extends T> type, @Nullable Filter filter,
            @Nullable QueryExtInfo queryExtInfo) {
        Util.checkRowKey(rowKey);
        Util.checkNull(type);

        HTableInterface htableInterface = htableInterface();

        try {

            Get get = constructGet(rowKey, filter);

            if (queryExtInfo != null) {
                if (queryExtInfo.isMaxVersionSet()) {
                    get.setMaxVersions(queryExtInfo.getMaxVersions());
                }
                if (queryExtInfo.isTimeRangeSet()) {
                    get.setTimeRange(queryExtInfo.getMinStamp(),
                            queryExtInfo.getMaxStamp());
                }
            }

            applyRequestFamilyAndQualifier(type, get);

            return convertToSimpleHbaseDOResult(htableInterface.get(get), type);

        } catch (IOException e) {
            throw new SimpleHBaseException("findObject_internal_mv. rowKey="
                    + rowKey + " type=" + type, e);
        } finally {
            Util.close(htableInterface);
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
    public <T> List<List<SimpleHbaseDOResult<T>>> findObjectListMV(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            String id, Map<String, Object> para, QueryExtInfo queryExtInfo) {

        Filter filter = parseSelectFilter(id, para);
        return findObjectList_internal_mv(startRowKey, endRowKey, type, filter,
                queryExtInfo);
    }

    private <T> List<List<SimpleHbaseDOResult<T>>> findObjectList_internal_mv(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            @Nullable Filter filter, @Nullable QueryExtInfo queryExtInfo) {
        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);
        Util.checkNull(type);

        Scan scan = constructScan(startRowKey, endRowKey, filter, queryExtInfo);

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
                List<SimpleHbaseDOResult<T>> tem = convertToSimpleHbaseDOResult(
                        result, type);
                if (!tem.isEmpty()) {
                    resultList.add(tem);
                    if (++resultCounter >= length) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new SimpleHBaseException(
                    "findObjectList_internal_mv. startRowKey=" + startRowKey
                            + " endRowKey=" + endRowKey + " type=" + type, e);
        } finally {
            Util.close(resultScanner);
            Util.close(htableInterface);
        }

        return resultList;
    }

    @Nullable
    private Filter parseSelectFilter(String id, Map<String, Object> para) {
        HBaseQuery hbaseQuery = getHbaseTableConfig().getQueryMap().get(id);
        Util.checkNull(hbaseQuery);

        StringBuilder sb = new StringBuilder();
        Map<Object, Object> context = new HashMap<Object, Object>();
        hbaseQuery.getHqlNode().applyParaMap(para, sb, context,
                simpleHbaseRuntimeSetting);

        String hql = sb.toString().trim();

        if (StringUtil.isEmptyString(hql)) {
            return null;
        }

        ProgContext progContext = TreeUtil.parseProgContext(hql);
        return ContextUtil.parseSelectFilter(progContext, hbaseTableConfig,
                para, simpleHbaseRuntimeSetting);
    }

    @Override
    public <T> void putObjectMV(RowKey rowKey, T t, Date timestamp) {

        Util.checkNull(timestamp);

        putObjectMV(rowKey, t, timestamp.getTime());
    }

    @Override
    public <T> void putObjectMV(RowKey rowKey, T t, long timestamp) {

        List<PutRequest<T>> putRequestList = new ArrayList<PutRequest<T>>();
        putRequestList.add(new PutRequest<T>(rowKey, t, timestamp));

        putObjectList_internal(putRequestList);
    }

    @Override
    public <T> void putObjectListMV(List<PutRequest<T>> putRequestList,
            Date timestamp) {

        Util.checkNull(timestamp);

        putObjectListMV(putRequestList, timestamp.getTime());
    }

    @Override
    public <T> void putObjectListMV(List<PutRequest<T>> putRequestList,
            long timestamp) {

        applyTimeStampForPutRequest(putRequestList, timestamp);

        putObjectList_internal(putRequestList);
    }

    @Override
    public <T> void putObjectListMV(List<PutRequest<T>> putRequestList) {

        checkTimeStampForPutRequest(putRequestList);

        putObjectList_internal(putRequestList);
    }

    @Override
    public <T> void putObject(RowKey rowKey, T t) {

        List<PutRequest<T>> putRequestList = new ArrayList<PutRequest<T>>();
        putRequestList.add(new PutRequest<T>(rowKey, t));

        putObjectList(putRequestList);
    }

    @Override
    public <T> void putObjectList(List<PutRequest<T>> putRequestList) {

        cleanTimeStampForPutRequest(putRequestList);
        putObjectList_internal(putRequestList);
    }

    private <T> void cleanTimeStampForPutRequest(
            List<PutRequest<T>> putRequestList) {
        if (putRequestList == null || putRequestList.isEmpty()) {
            return;
        }

        for (PutRequest<T> putRequest : putRequestList) {
            if (putRequest != null) {
                putRequest.cleanTimestamp();
            }
        }
    }

    private <T> void applyTimeStampForPutRequest(
            List<PutRequest<T>> putRequestList, long timeStamp) {
        if (putRequestList == null || putRequestList.isEmpty()) {
            return;
        }

        for (PutRequest<T> putRequest : putRequestList) {
            if (putRequest != null) {
                putRequest.setTimestamp(timeStamp);
            }
        }
    }

    private <T> void checkTimeStampForPutRequest(
            List<PutRequest<T>> putRequestList) {
        if (putRequestList == null || putRequestList.isEmpty()) {
            return;
        }
        for (PutRequest<T> putRequest : putRequestList) {
            if (putRequest != null) {
                Util.checkNull(putRequest.getTimestamp());
            }
        }
    }

    private <T> void putObjectList_internal(List<PutRequest<T>> putRequestList) {

        Util.checkNull(putRequestList);

        if (putRequestList.isEmpty()) {
            return;
        }

        for (PutRequest<T> putRequest : putRequestList) {
            Util.checkPutRequest(putRequest);
        }

        TypeInfo typeInfo = findTypeInfo(putRequestList.get(0).getT()
                .getClass());

        List<Put> puts = new ArrayList<Put>();

        for (PutRequest<T> putRequest : putRequestList) {
            Put put = new Put(putRequest.getRowKey().toBytes());
            for (ColumnInfo columnInfo : typeInfo.getColumnInfos()) {
                byte[] value = convertPOJOFieldToBytes(putRequest.getT(),
                        columnInfo);
                if (putRequest.getTimestamp() == null) {
                    put.add(columnInfo.familyBytes, columnInfo.qualifierBytes,
                            value);
                } else {
                    put.add(columnInfo.familyBytes, columnInfo.qualifierBytes,
                            putRequest.getTimestamp().longValue(), value);
                }
            }

            puts.add(put);
        }

        HTableInterface htableInterface = htableInterface();

        try {
            htableInterface.put(puts);
        } catch (IOException e) {
            throw new SimpleHBaseException(
                    "putObjectList_internal. putRequestList=" + putRequestList,
                    e);
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

        TypeInfo typeInfo = findTypeInfo(newT.getClass());
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

        TypeInfo typeInfo = findTypeInfo(t.getClass());
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
    public void put(String hql) {
        Util.checkEmptyString(hql);

        ProgContext progContext = TreeUtil.parseProgContext(hql);
        InserthqlcContext context = ContextUtil
                .parseInserthqlcContext(progContext);
        Util.checkNull(context);

        String tableName = TreeUtil.parseTableName(progContext);
        checkTableName(tableName);

        List<HBaseColumnSchema> hbaseColumnSchemaList = ContextUtil
                .parseHBaseColumnSchemaList(hbaseTableConfig, context.cidList());
        List<Constant2Context> constant2ContextList = context.constant2List()
                .constant2();
        Util.check(hbaseColumnSchemaList.size() == constant2ContextList.size());

        RowkeyexpContext rowkeyexpContext = context.rowkeyexp();
        RowKey rowKey = ContextUtil.parseRowKey(rowkeyexpContext,
                simpleHbaseRuntimeSetting);
        Util.checkRowKey(rowKey);

        Date ts = null;
        TsexpContext tsexpContext = context.tsexp();
        if (tsexpContext != null) {
            ts = ContextUtil.parseTimeStampDate(tsexpContext,
                    simpleHbaseRuntimeSetting);
        }

        Put put = new Put(rowKey.toBytes());
        for (int i = 0; i < hbaseColumnSchemaList.size(); i++) {
            HBaseColumnSchema hbaseColumnSchema = hbaseColumnSchemaList.get(i);
            Constant2Context constant2Context = constant2ContextList.get(i);
            Object value = ContextUtil.parseConstant2(hbaseColumnSchema,
                    constant2Context, simpleHbaseRuntimeSetting);
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
        ProgContext progContext = TreeUtil.parseProgContext(hql);
        SelecthqlcContext context = ContextUtil
                .parseSelecthqlcContext(progContext);
        Util.checkNull(context);

        //tableName
        String tableName = TreeUtil.parseTableName(progContext);
        checkTableName(tableName);

        //cid list
        SelectCidListContext selectCidListContext = context.selectCidList();
        List<HBaseColumnSchema> hbaseColumnSchemaList = ContextUtil
                .parseHBaseColumnSchemaList(hbaseTableConfig,
                        selectCidListContext);
        Util.check(!hbaseColumnSchemaList.isEmpty());

        //filter
        Filter filter = ContextUtil.parseFilter(context.wherec(),
                hbaseTableConfig, simpleHbaseRuntimeSetting);

        //rowkeys.        
        RowKeyRange rowKeyRange = ContextUtil.parseRowKeyRange(
                context.rowkeyrange(), simpleHbaseRuntimeSetting);

        RowKey startRowKey = rowKeyRange.getStart();
        RowKey endRowKey = rowKeyRange.getEnd();

        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);

        //queryExtInfo
        QueryExtInfo queryExtInfo = ContextUtil.parseQueryExtInfo(context,
                simpleHbaseRuntimeSetting);

        //scan
        Scan scan = constructScan(startRowKey, endRowKey, filter, queryExtInfo);

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
                List<SimpleHbaseCellResult> tem = convertToSimpleHbaseCellResultList(result);
                if (!tem.isEmpty()) {
                    resultList.add(tem);
                    if (++resultCounter >= length) {
                        break;
                    }
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
    public void deleteObjectMV(RowKey rowKey, Class<?> type, Date timeStamp) {

        Util.checkNull(timeStamp);

        deleteObjectMV(rowKey, type, timeStamp.getTime());
    }

    @Override
    public void deleteObjectMV(RowKey rowKey, Class<?> type, long timeStamp) {

        List<DeleteRequest> deleteRequestList = new ArrayList<DeleteRequest>();
        deleteRequestList.add(new DeleteRequest(rowKey, timeStamp));

        deleteObjectList_byRowKey_internal(deleteRequestList, type);
    }

    @Override
    public void deleteObjectListMV(List<RowKey> rowKeyList, Class<?> type,
            Date timeStamp) {

        Util.checkNull(timeStamp);

        deleteObjectListMV(rowKeyList, type, timeStamp.getTime());
    }

    @Override
    public void deleteObjectListMV(List<RowKey> rowKeyList, Class<?> type,
            long timeStamp) {

        Util.checkNull(rowKeyList);

        List<DeleteRequest> deleteRequestList = new ArrayList<DeleteRequest>();
        for (RowKey rowKey : rowKeyList) {
            deleteRequestList.add(new DeleteRequest(rowKey, timeStamp));
        }

        deleteObjectList_byRowKey_internal(deleteRequestList, type);
    }

    @Override
    public void deleteObjectListMV(List<DeleteRequest> deleteRequestList,
            Class<?> type) {

        checkTimeStampForDeleteRequest(deleteRequestList);

        deleteObjectList_byRowKey_internal(deleteRequestList, type);
    }

    @Override
    public void deleteObject(RowKey rowKey, Class<?> type) {
        List<RowKey> rowKeyList = new ArrayList<RowKey>();
        rowKeyList.add(rowKey);
        deleteObjectList(rowKeyList, type);
    }

    @Override
    public void deleteObjectList(List<RowKey> rowKeyList, Class<?> type) {
        Util.checkNull(rowKeyList);

        List<DeleteRequest> deleteRequestList = new ArrayList<DeleteRequest>();
        for (RowKey rowKey : rowKeyList) {
            deleteRequestList.add(new DeleteRequest(rowKey));
        }

        deleteObjectList_byRowKey_internal(deleteRequestList, type);
    }

    private void checkTimeStampForDeleteRequest(
            List<DeleteRequest> deleteRequestList) {
        if (deleteRequestList == null || deleteRequestList.isEmpty()) {
            return;
        }

        for (DeleteRequest deleteRequest : deleteRequestList) {
            if (deleteRequest != null) {
                Util.checkNull(deleteRequest.getTimestamp());
            }
        }
    }

    private void deleteObjectList_byRowKey_internal(
            List<DeleteRequest> deleteRequestList, Class<?> type) {

        Util.checkNull(deleteRequestList);
        Util.checkNull(type);

        if (deleteRequestList.isEmpty()) {
            return;
        }

        for (DeleteRequest deleteRequest : deleteRequestList) {
            Util.checkDeleteRequest(deleteRequest);
        }

        TypeInfo typeInfo = findTypeInfo(type);
        List<ColumnInfo> columnInfoList = typeInfo.getColumnInfos();

        List<Delete> deletes = new LinkedList<Delete>();

        for (DeleteRequest deleteRequest : deleteRequestList) {
            Delete delete = new Delete(deleteRequest.getRowKey().toBytes());
            for (ColumnInfo columnInfo : columnInfoList) {
                if (deleteRequest.getTimestamp() == null) {
                    //delete all versions.
                    delete.deleteColumns(columnInfo.familyBytes,
                            columnInfo.qualifierBytes);
                } else {
                    //delete specified version.
                    delete.deleteColumn(columnInfo.familyBytes,
                            columnInfo.qualifierBytes, deleteRequest
                                    .getTimestamp().longValue());
                }
            }
            deletes.add(delete);
        }

        HTableInterface htableInterface = htableInterface();
        try {
            htableInterface.delete(deletes);
        } catch (IOException e) {
            throw new SimpleHBaseException(
                    "deleteObjectList_internal. deleteRequestList = "
                            + deleteRequestList, e);
        } finally {
            Util.close(htableInterface);
        }

        //successful delete will clear the items of deletes list.
        if (deletes.size() > 0) {
            throw new SimpleHBaseException(
                    "deleteObjectList_internal. deletes=" + deletes);
        }
    }

    @Override
    public void deleteObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<?> type) {
        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);
        Util.checkNull(type);

        TypeInfo typeInfo = findTypeInfo(type);
        List<ColumnInfo> columnInfoList = typeInfo.getColumnInfos();

        delete_internal_with_scan_first(startRowKey, endRowKey, null,
                columnInfoList, null, null);
    }

    @Override
    public void delete(String hql) {
        Util.checkEmptyString(hql);
        ProgContext progContext = TreeUtil.parseProgContext(hql);
        DeletehqlcContext context = ContextUtil
                .parseDeletehqlcContext(progContext);
        Util.checkNull(context);

        //tableName
        String tableName = TreeUtil.parseTableName(progContext);
        checkTableName(tableName);

        //cid list
        SelectCidListContext selectCidListContext = context.selectCidList();
        List<HBaseColumnSchema> hbaseColumnSchemaList = ContextUtil
                .parseHBaseColumnSchemaList(hbaseTableConfig,
                        selectCidListContext);
        Util.check(!hbaseColumnSchemaList.isEmpty());

        //filter
        Filter filter = ContextUtil.parseFilter(context.wherec(),
                hbaseTableConfig, simpleHbaseRuntimeSetting);

        //rowkeys.
        RowKeyRange rowKeyRange = ContextUtil.parseRowKeyRange(
                context.rowkeyrange(), simpleHbaseRuntimeSetting);

        RowKey startRowKey = rowKeyRange.getStart();
        RowKey endRowKey = rowKeyRange.getEnd();

        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);

        Date ts = null;
        TsexpContext tsexpContext = context.tsexp();
        if (tsexpContext != null) {
            ts = ContextUtil.parseTimeStampDate(tsexpContext,
                    simpleHbaseRuntimeSetting);
        }

        delete_internal_with_scan_first(startRowKey, endRowKey, filter, null,
                hbaseColumnSchemaList, ts);
    }

    /**
     * columnInfoList and hbaseColumnSchemaList can not be null or empty both.
     * */
    private void delete_internal_with_scan_first(RowKey startRowKey,
            RowKey endRowKey, @Nullable Filter filter,
            @Nullable List<ColumnInfo> columnInfoList,
            @Nullable List<HBaseColumnSchema> hbaseColumnSchemaList,
            @Nullable Date ts) {

        Util.check((columnInfoList != null && !columnInfoList.isEmpty())
                || (hbaseColumnSchemaList != null && !hbaseColumnSchemaList
                        .isEmpty()));

        final int deleteBatch = getDeleteBatch();

        while (true) {

            RowKey nextStartRowkey = startRowKey;
            Scan temScan = constructScan(nextStartRowkey, endRowKey, filter,
                    null);

            List<Delete> deletes = new LinkedList<Delete>();

            HTableInterface htableInterface = htableInterface();
            ResultScanner resultScanner = null;
            try {
                resultScanner = htableInterface.getScanner(temScan);
                Result result = null;
                while ((result = resultScanner.next()) != null) {

                    Delete delete = new Delete(result.getRow());
                    nextStartRowkey = new BytesRowKey(result.getRow());

                    if (columnInfoList != null) {
                        for (ColumnInfo columnInfo : columnInfoList) {
                            if (ts == null) {
                                //delete all versions.
                                delete.deleteColumns(columnInfo.familyBytes,
                                        columnInfo.qualifierBytes);
                            } else {
                                //delete specified version.
                                delete.deleteColumn(columnInfo.familyBytes,
                                        columnInfo.qualifierBytes, ts.getTime());
                            }
                        }
                    }

                    if (hbaseColumnSchemaList != null) {
                        for (HBaseColumnSchema hbaseColumnSchema : hbaseColumnSchemaList) {
                            if (ts == null) {
                                //delete all versions.
                                delete.deleteColumns(
                                        hbaseColumnSchema.getFamilyBytes(),
                                        hbaseColumnSchema.getQualifierBytes());
                            } else {
                                //delete specified version.
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

    @Override
    public long count(RowKey startRowKey, RowKey endRowKey) {
        return count(startRowKey, endRowKey, null, null, null);
    }

    @Override
    public long count(RowKey startRowKey, RowKey endRowKey,
            @Nullable AggregateExtInfo aggregateExtInfo) {
        return count(startRowKey, endRowKey, null, null, aggregateExtInfo);
    }

    @Override
    public long count(RowKey startRowKey, RowKey endRowKey,
            @Nullable String id, @Nullable Map<String, Object> para) {
        return count(startRowKey, endRowKey, id, para, null);
    }

    @Override
    public long count(RowKey startRowKey, RowKey endRowKey,
            @Nullable String id, @Nullable Map<String, Object> para,
            @Nullable AggregateExtInfo aggregateExtInfo) {
        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);

        if (StringUtil.isEmptyString(id)) {
            return count_internal(startRowKey, endRowKey, null,
                    aggregateExtInfo);
        }

        HBaseQuery hbaseQuery = getHbaseTableConfig().getQueryMap().get(id);
        Util.checkNull(hbaseQuery);

        StringBuilder sb = new StringBuilder();
        Map<Object, Object> context = new HashMap<Object, Object>();
        hbaseQuery.getHqlNode().applyParaMap(para, sb, context,
                simpleHbaseRuntimeSetting);

        String hql = sb.toString().trim();
        Util.checkEmptyString(hql);

        ProgContext progContext = TreeUtil.parseProgContext(hql);

        Filter filter = ContextUtil.parseCountFilter(progContext,
                hbaseTableConfig, para, simpleHbaseRuntimeSetting);

        return count_internal(startRowKey, endRowKey, filter, aggregateExtInfo);

    }

    private long count_internal(RowKey startRowKey, RowKey endRowKey,
            @Nullable Filter filter, @Nullable AggregateExtInfo aggregateExtInfo) {

        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);

        Filter resultFilter = null;
        if (filter != null && aggregateExtInfo != null) {
            resultFilter = new FilterList(Operator.MUST_PASS_ALL, filter,
                    new PageFilter(aggregateExtInfo.getLimit()));
        } else if (filter != null) {
            resultFilter = filter;
        } else if (aggregateExtInfo != null) {
            resultFilter = new PageFilter(aggregateExtInfo.getLimit());
        }

        Scan scan = constructScan(startRowKey, endRowKey, resultFilter, null);

        applyRequestFamilyAndQualifier(scan);

        LongColumnInterpreter columnInterpreter = new LongColumnInterpreter();
        AggregationClient aggregationClient = aggregationClient();
        try {
            //No need to close HTable,the AggregationClient close it.
            return aggregationClient.rowCount(tableNameBytes(),
                    columnInterpreter, scan);

        } catch (Throwable t) {
            throw new SimpleHBaseException("count_internal.", t);
        }
    }

    @Override
    public long[] countAndSum(RowKey startRowKey, RowKey endRowKey) {
        return countAndSum(startRowKey, endRowKey, null, null, null);
    }

    @Override
    public long[] countAndSum(RowKey startRowKey, RowKey endRowKey,
            @Nullable AggregateExtInfo aggregateExtInfo) {
        return countAndSum(startRowKey, endRowKey, null, null, aggregateExtInfo);
    }

    @Override
    public long[] countAndSum(RowKey startRowKey, RowKey endRowKey,
            @Nullable String id, @Nullable Map<String, Object> para) {
        return countAndSum(startRowKey, endRowKey, id, para, null);
    }

    @Override
    public long[] countAndSum(RowKey startRowKey, RowKey endRowKey,
            @Nullable String id, @Nullable Map<String, Object> para,
            @Nullable AggregateExtInfo aggregateExtInfo) {

        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);

        if (StringUtil.isEmptyString(id)) {
            return countAndSum_internal(startRowKey, endRowKey, null, null,
                    aggregateExtInfo);
        }

        HBaseQuery hbaseQuery = getHbaseTableConfig().getQueryMap().get(id);
        Util.checkNull(hbaseQuery);

        StringBuilder sb = new StringBuilder();
        Map<Object, Object> context = new HashMap<Object, Object>();
        hbaseQuery.getHqlNode().applyParaMap(para, sb, context,
                simpleHbaseRuntimeSetting);

        String hql = sb.toString().trim();
        Util.checkEmptyString(hql);

        ProgContext progContext = TreeUtil.parseProgContext(hql);

        Filter filter = ContextUtil.parseCountSumFilter(progContext,
                hbaseTableConfig, para, simpleHbaseRuntimeSetting);

        CountsumclContext countsumclContext = ((CountsumclContext) progContext);
        List<HBaseColumnSchema> hbaseColumnSchemaList = ContextUtil
                .parseHBaseColumnSchemaList(hbaseTableConfig, countsumclContext
                        .countsumc().cidList());

        return countAndSum_internal(startRowKey, endRowKey,
                hbaseColumnSchemaList, filter, aggregateExtInfo);
    }

    private long[] countAndSum_internal(RowKey startRowKey, RowKey endRowKey,
            @Nullable List<HBaseColumnSchema> hbaseColumnSchemaList,
            @Nullable Filter filter, @Nullable AggregateExtInfo aggregateExtInfo) {

        Util.checkRowKey(startRowKey);
        Util.checkRowKey(endRowKey);

        Filter resultFilter = null;
        if (filter != null && aggregateExtInfo != null) {
            resultFilter = new FilterList(Operator.MUST_PASS_ALL, filter,
                    new PageFilter(aggregateExtInfo.getLimit()));
        } else if (filter != null) {
            resultFilter = filter;
        } else if (aggregateExtInfo != null) {
            resultFilter = new PageFilter(aggregateExtInfo.getLimit());
        }

        Scan scan = constructScan(startRowKey, endRowKey, resultFilter, null);

        applyRequestFamilyAndQualifier(scan);

        AggrRequest aggrRequest = new AggrRequest();
        if (hbaseColumnSchemaList != null) {
            for (HBaseColumnSchema columnSchema : hbaseColumnSchemaList) {
                aggrRequest.add(columnSchema.getFamily(),
                        columnSchema.getQualifier());
            }
        }
        AggrHandler aggrHandler = new AggrHandler(aggrRequest);

        HTableInterface htableInterface = htableInterface();
        try {
            CpClient2 client2 = new CpClient2(htableInterface);
            AggrResult aggrResult = client2.call(aggrHandler,
                    new AggrReducer(), scan);
            long[] result = new long[aggrResult.getColumnSize() + 1];
            result[0] = aggrResult.getCount();
            for (int i = 0; i < aggrResult.getColumnSize(); i++) {
                result[i + 1] = aggrResult.getSum(i);
            }
            return result;
        } catch (Throwable t) {
            throw new SimpleHBaseException("countAndSum_internal.", t);
        } finally {
            Util.close(htableInterface);
        }
    }
}
