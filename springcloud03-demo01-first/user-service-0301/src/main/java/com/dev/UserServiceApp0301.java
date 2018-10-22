package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/*
 * @EnableDiscoveryClient就并没有规定服务注册中心的具体组件，可以是eureka,也可以是zookeeper
 * @EnableEurekaClient 就是开启eureka发现服务。
 * 这里两个都可以用，但要注意两者的区别
 */
@SpringBootApplication
@MapperScan("com.dev.mapper")
@EnableDiscoveryClient //启动发现服务的功能
public class UserServiceApp0301 {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApp0301.class,args);
	}
}
