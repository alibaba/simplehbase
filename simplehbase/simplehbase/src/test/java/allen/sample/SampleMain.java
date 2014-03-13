package allen.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;

import com.alipay.simplehbase.client.SimpleHbaseClient;

import com.alipay.simplehbase.client.SimpleHbaseClientImpl;

import com.alipay.simplehbase.config.HBaseDataSource;
import com.alipay.simplehbase.config.HBaseTableConfig;

/**
 * @author xinzhi
 * */
public class SampleMain {

    /** log. */
    final private static Logger log = Logger.getLogger(SampleMain.class);

    private static SimpleHbaseClient getSimpleHbaseClient() {
        HBaseDataSource hbaseDataSource = new HBaseDataSource();
        List<String> hbaseConfigFilePaths = new ArrayList<String>();
        //hbase config file.
        hbaseConfigFilePaths.add("sample\\hbase_site");
        //zk config file.
        hbaseConfigFilePaths.add("sample\\zk_conf");
        hbaseDataSource.setHbaseConfigFilePaths(hbaseConfigFilePaths);
        hbaseDataSource.init();

        HBaseTableConfig hbaseTableConfig = new HBaseTableConfig();
        //simplehbase config file.
        hbaseTableConfig.setConfigResource(new FileSystemResource(
                "sample\\myRecord.xml"));

        hbaseTableConfig.init();

        SimpleHbaseClient tClient = new SimpleHbaseClientImpl();
        tClient.setHbaseDataSource(hbaseDataSource);
        tClient.setHbaseTableConfig(hbaseTableConfig);

        return tClient;
    }

    public static void main(String[] args) throws Exception {

        SimpleHbaseClient simpleHbaseClient = getSimpleHbaseClient();

        //insert one record.
        Person one = new Person();
        one.setId(1);
        one.setName("allen");
        one.setAge(30);
        one.setGender(Gender.MALE);
        simpleHbaseClient.putObject(new PersonRowKey(1), one);

        //insert another record.
        Person two = new Person();
        two.setId(2);
        two.setName("dan");
        two.setAge(31);
        two.setGender(Gender.FEMALE);
        simpleHbaseClient.putObject(new PersonRowKey(2), two);

        //search by row key.
        Person result = simpleHbaseClient.findObject(new PersonRowKey(1),
                Person.class);
        log.info(result);

        //search by range.
        List<Person> resultList = simpleHbaseClient.findObjectList(
                new PersonRowKey(1), new PersonRowKey(3), Person.class);
        log.info(resultList);

        //dynamic query.
        Map<String, Object> para = new HashMap<String, Object>();
        para.put("id", 0);
        resultList = simpleHbaseClient.findObjectList(new PersonRowKey(1),
                new PersonRowKey(3), Person.class, "queryByNameAndAge", para);
        log.info(resultList);

        //dynamic query.
        para.put("name", "allen");
        para.put("age", 0);
        resultList = simpleHbaseClient.findObjectList(new PersonRowKey(1),
                new PersonRowKey(3), Person.class, "queryByNameAndAge", para);
        log.info(resultList);

        //batch delete.
        simpleHbaseClient.deleteObjectList(new PersonRowKey(0),
                new PersonRowKey(100), Person.class);

    }
}
