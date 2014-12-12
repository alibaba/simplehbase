package com.alipay.simplehbase.client;

/**
 * AggregateExtInfo.
 * 
 * <pre>
 * Extra info when do aggregate. So far, the following info can be supplied.
 * 
 * limit.
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public class AggregateExtInfo {
    /**
     * Like limit in the SQL.
     * 
     * <pre>
     * Note that the limit's implementation is using PageFilter.
     * 
     * That filter cannot guarantee that the number of results
     * returned to a client are <= page size. This is because the filter is
     * applied separately on different region servers. It does however optimize
     * the scan of individual HRegions by making sure that the page size is
     * never exceeded locally.
     * </pre>
     * */
    private long limit;

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }
}
