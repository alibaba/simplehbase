package com.alipay.simplehbase.util;

import java.io.IOException;

import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.ResultScanner;

import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.client.TypeInfo;
import com.alipay.simplehbase.exception.SimpleHBaseException;

/**
 * Client Util.
 * 
 * @author xinzhi
 * */
public class Util {

    /**
     * Check object is NOT null.
     * 
     * */
    public static void checkNull(Object obj) {
        if (obj == null) {
            throw new SimpleHBaseException("object is null.");
        }
    }

    /**
     * Check rowKey.
     * 
     * <pre>
     * rowKey is not null.
     * the result of rowKey's toBytes is not null.
     * </pre>
     * 
     * */
    public static void checkRowKey(RowKey rowKey) {
        if (rowKey == null) {
            throw new SimpleHBaseException("rowkey is null.");
        }
        if (rowKey.toBytes() == null) {
            throw new SimpleHBaseException("rowkey bytes is null.");
        }
    }

    /**
     * Close HTableInterface.
     * */
    public static void close(HTableInterface htableInterface) {
        if (htableInterface == null) {
            return;
        }

        try {
            htableInterface.close();
        } catch (IOException e) {
            throw new SimpleHBaseException("close htableInterface exception.",
                    e);
        }
    }

    /**
     * Close ResultScanner.
     * */
    public static void close(ResultScanner resultScanner) {
        if (resultScanner == null) {
            return;
        }
        resultScanner.close();
    }

    /**
     * Check for typeInfo is versioned typeInfo.
     * */
    public static void checkVersioned(TypeInfo typeInfo) {
        checkNull(typeInfo);
        if (!typeInfo.isVersionedType()) {
            throw new SimpleHBaseException("not a versioned type. typeInfo = "
                    + typeInfo.getType());
        }
    }

    /**
     * Check for 2 objects have same type.
     * */
    public static void checkSameType(Object one, Object other) {
        checkNull(one);
        checkNull(other);
        if (one.getClass() != other.getClass()) {
            throw new SimpleHBaseException("not same type. one = " + one
                    + " other = " + other);
        }
    }

    private Util() {
    }
}
