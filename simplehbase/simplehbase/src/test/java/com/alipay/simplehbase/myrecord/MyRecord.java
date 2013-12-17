package com.alipay.simplehbase.myrecord;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.alipay.simplehbase.client.HBaseColumn;
import com.alipay.simplehbase.client.HBaseTable;
import com.alipay.simplehbase.client.HBaseVersion;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (age ^ (age >>> 32));
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (int) (version ^ (version >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyRecord other = (MyRecord) obj;
        if (age != other.age)
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (gender != other.gender)
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (version != other.version)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
