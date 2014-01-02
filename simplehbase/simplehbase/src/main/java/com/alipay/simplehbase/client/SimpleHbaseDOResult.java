package com.alipay.simplehbase.client;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * SimpleHbaseDOResult.
 * 
 * <pre>
 * SimpleHbase mapping DO result with extra info.
 * <list>
 * timestamp.
 * </list>
 * </pre>
 * */
public class SimpleHbaseDOResult<T> {

    /** The mapping result of DO. */
    private T    t;
    /** Hbase timestamp. */
    private long timestamp;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
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
