package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.dev.mapper")
public class UserServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApp.class,args);
	}
}
