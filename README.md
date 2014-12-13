simplehbase
=========== 
simplehbase是java和hbase之间的轻量级中间件。 主要包含以下功能。
*  数据类型映射：java类型和hbase的bytes之间的数据转换。
*  简单操作封装：封装了hbase的put,get,scan等操作为简单的java操作方式。
*  hbase query封装：封装了hbase的filter，可以使用sql-like的方式操作hbase。
*  动态query封装：类似于myibatis，可以使用xml配置动态语句查询hbase。
*  insert,update支持: 建立在hbase的checkAndPut之上。
*  hbase多版本支持：提供接口可以对hbase多版本数据进行查询,映射。
*  hbase批量操作支持。
*  hbase原生接口支持。
*  HTablePool管理。
*  HTable count和sum功能。




