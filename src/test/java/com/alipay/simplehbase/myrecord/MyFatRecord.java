package com.alipay.simplehbase.myrecord;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import allen.test.Config;

import com.alipay.simplehbase.client.HBaseColumn;
import com.alipay.simplehbase.client.HBaseTable;
import com.alipay.simplehbase.client.HBaseVersion;
import com.alipay.simplehbase.client.RowKey;

/**
 * @author xinzhi
 */
@HBaseTable(defaultFamily = Config.ColumnFamilyName)
public class MyFatRecord {

    @HBaseColumn(qualifier = "id")
    private int    id;
    @HBaseColumn(qualifier = "name")
    private String name;
    @HBaseColumn(qualifier = "date")
    private Date   date;
    @HBaseColumn(qualifier = "gender")
    private Gender gender;
    @HBaseColumn(qualifier = "age")
    private long   age;
    @HBaseVersion
    @HBaseColumn(qualifier = "version")
    private long   version;

    @HBaseColumn(qualifier = "fatid")
    private int    fatid;
    @HBaseColumn(qualifier = "fatname")
    private String fatname;
    @HBaseColumn(qualifier = "fatdate")
    private Date   fatdate;
    @HBaseColumn(qualifier = "fatgender")
    private Gender fatgender;
    @HBaseColumn(qualifier = "fatage")
    private long   fatage;
    @HBaseColumn(qualifier = "fatversion")
    private long   fatversion;

    public MyRecord toSlim() {
        MyRecord result = new MyRecord();
        result.setAge(age);
        result.setDate(date);
        result.setGender(gender);
        result.setId(id);
        result.setName(name);
        result.setVersion(version);
        return result;
    }

    public RowKey rowKey() {
        return new MyRecordRowKey(id);
    }

    public long getFatversion() {
        return fatversion;
    }

    public void setFatversion(long fatversion) {
        this.fatversion = fatversion;
    }

    public int getFatid() {
        return fatid;
    }

    public void setFatid(int fatid) {
        this.fatid = fatid;
    }

    public String getFatname() {
        return fatname;
    }

    public void setFatname(String fatname) {
        this.fatname = fatname;
    }

    public Date getFatdate() {
        return fatdate;
    }

    public void setFatdate(Date fatdate) {
        this.fatdate = fatdate;
    }

    public Gender getFatgender() {
        return fatgender;
    }

    public void setFatgender(Gender fatgender) {
        this.fatgender = fatgender;
    }

    public long getFatage() {
        return fatage;
    }

    public void setFatage(long fatage) {
        this.fatage = fatage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
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
