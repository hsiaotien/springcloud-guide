eureka-service : eureka的服务注册中心。

几个步骤需要完成：
    
    1.启动类需要注解@EnableEurekaServer;
    2.application.yml配置文件需要配置几个属性，
        a.服务名称；
        b.是否需要注册到其他eureka-server;
        c.是否需要从其他eureka-server服务注册中心拉取列表；
        d.注册中心节点（一个或者多个）
        e.实例id,用于展示
    在开发环境还需要设计几个属性，及时剔除及时拉取。
        a.服务剔除时间间隔周期
        b.eureka是否开启自动保护
        