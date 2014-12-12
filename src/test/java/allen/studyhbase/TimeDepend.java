package allen.studyhbase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Flag to indicate the test method's result depends on time.
 * 
 * <pre>
 * So we should delete and re-create table, to clear all the data in table (including delete mark).
 * </pre>
 * 
 * @author xinzhi
 * */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.SOURCE)
public @interface TimeDepend {
}
