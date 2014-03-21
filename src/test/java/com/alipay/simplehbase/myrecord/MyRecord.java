package com.alipay.simplehbase.myrecord;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.alipay.simplehbase.client.HBaseColumn;
import com.alipay.simplehbase.client.HBaseTable;
import com.alipay.simplehbase.client.HBaseVersion;
import com.alipay.simplehbase.client.RowKey;
import com.alipay.simplehbase.config.Config;

/**
 * @author xinzhi
 */
@HBaseTable(defaultFamily = Config.ColumnFamilyName)
public class MyRecord {

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

    public RowKey rowKey() {
        return new MyRecordRowKey(id);
    }

    public MyFatRecord toFat() {
        MyFatRecord result = new MyFatRecord();
        result.setAge(age);
        result.setDate(date);
        result.setGender(gender);
        result.setId(id);
        result.setName(name);
        result.setVersion(version);
        return result;
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
