package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringCloud01Demo03App {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloud01Demo03App.class,args);
	}

	// restTemplate需要交给spring管理，需要配置类进行配置，
	// 考虑到@springbootapplication的元注解就有@Configuration. 在此@bean即可配置
	@Bean
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}
}
