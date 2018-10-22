package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient//开启eureka客户端
@EnableHystrix //启动熔断
@EnableFeignClients //开启feign功能
public class ConsumerDemo0305App {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDemo0305App.class,args);
    }

    //启动类中注入resttemplate(如果不传,它有一个自带的)
//    @Bean
//    @LoadBalanced //ribbon负载均衡组件已经被eureka依赖而引入. 无需引包.
    /*
    负载均衡的原理: 负载均衡是通过代理方式,对resttemplate代理,是通过拦截器进行拦截处理.
    在何处拦截, 跟进源码,可以看到消费者发送远程请求后才拦截的, 那么是如何选择不同的instanceId来处理呢?
    跟进源码,可以看到,它将serverID 传入,来选择默认的rule( 如默认的轮询方式), 可以看到是通过轮询的方式完成负载均衡的.
    此外,可以看到这里提供了配置方案,可以对rule进行设置.
    此外. 这种轮询的rule解决了负载均衡的问题. 但负载均衡还需要解决的一个问题是: 某个提供者挂了, 被分配到该实例进行
    访问,会报出404或500错误. 那么这种负载均衡不是一个完美的解决方案.
    引入知识点. 负载均衡的重试机制. 注意使用的是spring提供的重试包. 在配置yml文件中进行重试机制的规则制定即可.
     */
//    public RestTemplate restTemplate(){
//        OkHttp3ClientHttpRequestFactory requestFactory = new OkHttp3ClientHttpRequestFactory();
//        RestTemplate restTemplate = new RestTemplate(requestFactory);
//        return restTemplate;
//    }
    /*
    Feign中已经自动集成了Ribbon负载均衡，因此我们不需要自己定义RestTemplate了
     */
}
