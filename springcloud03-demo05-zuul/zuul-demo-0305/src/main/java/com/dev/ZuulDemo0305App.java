package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient// 面向服务的路由配置，需要启用eureka功能，进行服务的拉取
@EnableHystrix //开启熔断功能，zuul也是看作消费者
public class ZuulDemo0305App {

	public static void main(String[] args) {
		SpringApplication.run(ZuulDemo0305App.class,args);
	}
}
