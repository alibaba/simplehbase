package com.alipay.simplehbase.client;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.log4j.Logger;

import com.alipay.simplehbase.config.HBaseDataSource;
import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * SimpleHbaseAdminClient的实现。
 * 
 * @author xinzhi
 * @version $Id: SimpleHbaseAdminClientImpl.java 2013-09-11 上午11:27:31 xinzhi $
 * */
public class SimpleHbaseAdminClientImpl implements SimpleHbaseAdminClient {

    /** log. */
    private static Logger   log = Logger.getLogger(SimpleHbaseAdminClientImpl.class);
    /**
     * HBaseDataSource。
     * */
    private HBaseDataSource hbaseDataSource;

    @Override
    public void createTable(HTableDescriptor tableDescriptor) {
        try {
            HBaseAdmin hbaseAdmin = hbaseDataSource.getHBaseAdmin();
            hbaseAdmin.createTable(tableDescriptor);
        } catch (Exception e) {
            log.error(e);
            throw new SimpleHBaseException(e);
        }
    }

    @Override
    public void deleteTable(String tableName) {
        try {
            HBaseAdmin hbaseAdmin = hbaseDataSource.getHBaseAdmin();
            // delete table if table exist.
            if (hbaseAdmin.tableExists(tableName)) {
                // disable table before delete it.
                if (!hbaseAdmin.isTableDisabled(tableName)) {
                    hbaseAdmin.disableTable(tableName);
                }
                hbaseAdmin.deleteTable(tableName);
            }
        } catch (Exception e) {
            log.error(e);
            throw new SimpleHBaseException(e);
        }
    }

    @Override
    public HBaseDataSource getHBaseDataSource() {
        return this.hbaseDataSource;
    }

    @Override
    public void setHBaseDataSource(HBaseDataSource hbaseDataSource) {
        this.hbaseDataSource = hbaseDataSource;
    }

}
