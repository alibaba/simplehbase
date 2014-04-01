package com.alipay.simplehbase.client;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.util.Util;

/**
 * DeleteRequest.
 * 
 * @author xinzhi.zhang
 * */
public class DeleteRequest {

    private RowKey rowKey;
    @Nullable
    private Long   timestamp;

    public DeleteRequest(RowKey rowKey) {
        this.rowKey = rowKey;
    }

    public DeleteRequest(RowKey rowKey, long timestamp) {
        this.rowKey = rowKey;
        this.timestamp = timestamp;
    }

    public DeleteRequest(RowKey rowKey, Date timestamp) {
        Util.checkNull(timestamp);
        this.rowKey = rowKey;
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
