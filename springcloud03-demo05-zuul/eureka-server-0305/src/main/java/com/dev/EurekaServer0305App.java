package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//声明这个应用是EurekaServer 应用
public class EurekaServer0305App {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer0305App.class,args);
	}
}
