关于序列化和反序列化的示例。
使用的jar包，是来自jackjson的jar包，
引入starter-web启动器，会自动引入jackjson相关的包。
序列化和反序列化使用的一个重要场景就是，
web项目中，远程调用的结果集的序列化和反序列化。
远程调用的结果集一般是json, 需要反序列化。
本地需要返回给前端的数据，需要序列化。

这就是web项目中，序列化和反序列化的一种重要应用场景