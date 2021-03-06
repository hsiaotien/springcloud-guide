package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // 开启Eureka客户端
public class ConsumerDemoApp0301 {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerDemoApp0301.class,args);
	}

	@Bean
	public RestTemplate restTemplate() {
		// 这次我们使用了OkHttp客户端,只需要注入工厂即可
		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}

}
