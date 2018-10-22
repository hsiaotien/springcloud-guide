package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.dev.mapper")
@EnableDiscoveryClient //启动发现服务的功能
public class UserService0305App {

	public static void main(String[] args) {
		SpringApplication.run(UserService0305App.class,args);
	}
}
