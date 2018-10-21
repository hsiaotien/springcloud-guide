Spring提供了一个RestTemplate模板工具类，
对基于Http的客户端进行了封装，并且实现了对象与json的序列化和反序列化，非常方便。
RestTemplate并没有限定Http的客户端类型，而是进行了抽象，
目前常用的3种都有支持：

- HttpClient
- OkHttp
- JDK原生的URLConnection（默认的）

可以得知RestTemplate模板工具类对http客户端和序列化反序列化进行了整合。
简化了过程。

脚下留心： 
RestTemplate需要配置类中进行配置，交由spring管理；
此外测试要用到spring容器，测试要指定启动类

