package com.dev.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    /*
    这是一个配置类,配置日志级别, 在feign中有部分日志没有起到作用,
    我理解为,对resttemplate日志的补偿.
    笔记的解释:通过logging.level.xx=debug来设置日志级别。
    然而这个对Fegin客户端而言不会产生效果。
    因为@FeignClient注解修改的客户端在被代理时，
    都会创建一个新的Fegin.Logger实例。我们需要额外指定这个日志的级别才可以。

     */
    @Bean// 还需要在替换resttemplate处的feign客户端处需要声明此配置
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
