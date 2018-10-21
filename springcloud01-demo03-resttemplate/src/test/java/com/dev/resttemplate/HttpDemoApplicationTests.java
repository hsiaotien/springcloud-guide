package com.dev.resttemplate;

import com.dev.SpringCloud01Demo03App;
import com.dev.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCloud01Demo03App.class)
public class HttpDemoApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void httpGet() {
		User user = this.restTemplate.getForObject("http://localhost/user/2", User.class);
		System.out.println(user);
	}

	/*
	restTemplate模板工具类对http和反序列化进行了抽象处理，简化操作。
	它还有许多类似的方法，如delete, post..等
	 */

}
