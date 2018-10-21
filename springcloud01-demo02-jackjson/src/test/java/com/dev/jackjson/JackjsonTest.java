package com.dev.jackjson;

import com.dev.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JackjsonTest {

	private ObjectMapper objectMapper = new ObjectMapper();

	/*
	ObjectMapper序列化和反序列化的方法test
	 */

	// 序列化 object => json
	@Test
	public void test01() throws JsonProcessingException {
		User user = new User();
		user.setUsername("lisi");
		user.setAge(16);
		// 序列化简单对象
		String userJson = objectMapper.writeValueAsString(user);
		System.out.println("userJson = " + userJson);

		// 序列化集合对象
		List<User> listUser = Arrays.asList(user, user);
		String listUserJson = objectMapper.writeValueAsString(listUser);
		System.out.println("listUserJson = " + listUserJson);
	}


	// json -> object  简单对象的反序列化
	@Test
	public void test02() throws IOException {
		String json = "{\"username\":\"zhangsan\",\"age\":18}";//可以假设这个json是http远程调用返回的json数据
		User user = objectMapper.readValue(json, User.class);
		System.out.println("user = " + user);
	}

	// 集合的反序列化
	@Test
	public void test03() throws IOException {
		// 拿到集合序列化后的json数据
		User user = new User();
		user.setUsername("lisi");
		user.setAge(16);
		List<User> listUserPre = Arrays.asList(user, user, user);
		String listUserJson = objectMapper.writeValueAsString(listUserPre);
		System.out.println("listUserJson = " + listUserJson);

		//反序列化一个集合
		List<User> listUser = objectMapper.readValue(listUserJson,
				objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));

		System.out.println("listUser = " + listUser);
	}

	// 超级复杂的对象，反序列化过程， 比如集合中套集合的json如何序列化？
	// 根据泛型反射，通用的反序列化的方式，可以应对简单或者复杂都可以。
	@Test
	public void test04() throws IOException {
		List<List<User>> listComplex = new ArrayList<>(); //嵌套的集合
		User user = new User();
		user.setUsername("lisi");
		user.setAge(16);
		List<User> listUserPre01 = Arrays.asList(user, user);
		List<User> listUserPre02 = Arrays.asList(user, user, user);
		listComplex.add(listUserPre01);
		listComplex.add(listUserPre02);

		//序列化 (可以看出虚拟化不需要区分简单复杂，都是同一个方法搞定，接收Object即所有类型对象）
		String listComplexJson = objectMapper.writeValueAsString(listComplex);
		System.out.println("listComplexJson = " + listComplexJson);

		//反序列化01， jackjson包提供了下面的类，根据泛型反射，实际上所有类型都可以通过该类来实现反序列化
		List<List<User>> list = objectMapper.readValue(listComplexJson, new TypeReference<List<List<User>>>() {
		});// 复杂的json
		System.out.println("list = " + list);
		/*
		要注意的是，这里的泛型是编译器的泛型，而不是运行期的泛型。
		编译期的泛型，不会擦除，直接编译到class文件中。
		 */

		//反序列化02
		String json = "{\"username\":\"zhangsan\",\"age\":18}";
		User u = objectMapper.readValue(json, new TypeReference<User>() {
		});
		System.out.println("u = " + u);
	}

	/*
	在util包中，自行封装了处理json的工具类。原理是相同的，即上述示例的方式进行封装抽取。
	 */
	// 后续测试这些工具中的方法。。。
}
