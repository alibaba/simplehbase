package com.alipay.simplehbase.client.service;

import java.util.List;

import com.alipay.simplehbase.client.SimpleHbaseCellResult;

/**
 * HbaseRawService.
 * 
 * <pre>
 * Provides hbase raw service.
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public interface HbaseRawService {

    /**
     * put data.
     * */
    public void put(String hql);

    /**
     * select data.
     * */
    public List<List<SimpleHbaseCellResult>> select(String hql);

    /**
     * delete data.
     * */
    public void delete(String hql);

}
