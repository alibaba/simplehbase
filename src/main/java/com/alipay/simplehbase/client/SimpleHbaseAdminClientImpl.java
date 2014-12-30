package com.alipay.simplehbase.client;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.log4j.Logger;

import com.alipay.simplehbase.config.HBaseDataSource;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.Util;

/**
 * SimpleHbaseAdminClient's implementation.
 * 
 * @author xinzhi
 * */
public class SimpleHbaseAdminClientImpl implements SimpleHbaseAdminClient {

    /** log. */
    private static Logger   log = Logger.getLogger(SimpleHbaseAdminClientImpl.class);
    /**
     * HBaseDataSource.
     * */
    private HBaseDataSource hbaseDataSource;

    @Override
    public void createTable(HTableDescriptor tableDescriptor) {
        Util.checkNull(tableDescriptor);

        try {
            HBaseAdmin hbaseAdmin = hbaseDataSource.getHBaseAdmin();
            NamespaceDescriptor[] namespaceDescriptors = hbaseAdmin
                    .listNamespaceDescriptors();
            String namespace = tableDescriptor.getTableName()
                    .getNamespaceAsString();
            boolean isExist = false;
            for (NamespaceDescriptor nd : namespaceDescriptors) {
                if (nd.getName().equals(namespace)) {
                    isExist = true;
                    break;
                }
            }
            log.info("namespace " + namespace + " isExist " + isExist);
            if (!isExist) {
                hbaseAdmin.createNamespace(NamespaceDescriptor
                        .create(namespace).build());
            }

            hbaseAdmin.createTable(tableDescriptor);
            HTableDescriptor newTableDescriptor = hbaseAdmin
                    .getTableDescriptor(tableDescriptor.getName());
            log.info("create table " + newTableDescriptor);
        } catch (Exception e) {
            log.error(e);
            throw new SimpleHBaseException(e);
        }
    }

    @Override
    public void deleteTable(String tableName) {
        Util.checkEmptyString(tableName);

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
    public HBaseDataSource getHbaseDataSource() {
        return this.hbaseDataSource;
    }

    @Override
    public void setHbaseDataSource(HBaseDataSource hbaseDataSource) {
        this.hbaseDataSource = hbaseDataSource;
    }

}
