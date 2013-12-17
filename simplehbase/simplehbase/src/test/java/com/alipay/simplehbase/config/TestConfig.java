package com.alipay.simplehbase.config;

public class TestConfig {

    public static String  TestHqlNodeXmlFile                = "test\\hql\\testHqlNode.xml";
    public static String  HbaseSiteFile                     = "test\\hbase_site";
    public static String  ZkConfigFile                      = "test\\zk_conf";
    public static String  MyRecordXmlFile                   = "test\\hql\\myRecord.xml";

    /**
     * Flag to control table creation.
     * 
     * <pre>
     * run CreateTestTable before set to false. 
     * run DeleteTestTable after running tests when set to false.
     * </pre>
     * 
     * */
    public static boolean ShouldDeleteAndCreateTablePerTest = false;
}
