package com.alipay.simplehbase.client;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * SimpleHbaseCellResult.
 * 
 * <pre>
 * SimpleHbase mapping result on hbase cell.
 * </pre>
 * 
 * @author xinzhi
 * */
public class SimpleHbaseCellResult {

    private Object rowObject;
    private String familyStr;
    private String qualifierStr;
    private Object valueObject;
    private Date   tsDate;

    public Object getRowObject() {
        return rowObject;
    }

    public void setRowObject(Object rowObject) {
        this.rowObject = rowObject;
    }

    public void setFamilyStr(String familyStr) {
        this.familyStr = familyStr;
    }

    public void setQualifierStr(String qualifierStr) {
        this.qualifierStr = qualifierStr;
    }

    public void setValueObject(Object valueObject) {
        this.valueObject = valueObject;
    }

    public void setTsDate(Date tsDate) {
        this.tsDate = tsDate;
    }

    public String getFamilyStr() {
        return familyStr;
    }

    public String getQualifierStr() {
        return qualifierStr;
    }

    public Object getValueObject() {
        return valueObject;
    }

    public Date getTsDate() {
        return tsDate;
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
