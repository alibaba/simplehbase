package allen.sample;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.alipay.simplehbase.client.HBaseColumn;
import com.alipay.simplehbase.client.HBaseTable;

/**
 * @author xinzhi
 */
@HBaseTable(defaultFamily = "MyRecordFamily")
public class Person {
    @HBaseColumn(qualifier = "id")
    private int    id;
    @HBaseColumn(qualifier = "name")
    private String name;
    @HBaseColumn(qualifier = "date")
    private Date   date;
    @HBaseColumn(qualifier = "gender")
    private Gender gender;
    @HBaseColumn(qualifier = "age")
    private int    age;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
