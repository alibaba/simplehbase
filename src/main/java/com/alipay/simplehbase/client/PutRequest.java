package com.alipay.simplehbase.client;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.util.Util;

/**
 * PutRequest.
 * 
 * @author xinzhi.zhang
 * */
public class PutRequest<T> {

    private RowKey rowKey;
    private T      t;
    @Nullable
    private Long   timestamp;

    public PutRequest(RowKey rowKey, T t) {
        this.rowKey = rowKey;
        this.t = t;
    }

    public PutRequest(RowKey rowKey, T t, long timestamp) {
        this.rowKey = rowKey;
        this.t = t;
        this.timestamp = timestamp;
    }

    public PutRequest(RowKey rowKey, T t, Date timestamp) {
        Util.checkNull(timestamp);

        this.rowKey = rowKey;
        this.t = t;
        this.timestamp = timestamp.getTime();
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setTimestamp(Date timestamp) {
        Util.checkNull(timestamp);
        this.timestamp = timestamp.getTime();
    }

    public void cleanTimestamp() {
        this.timestamp = null;
    }

    public RowKey getRowKey() {
        return rowKey;
    }

    public T getT() {
        return t;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
