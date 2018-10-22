package com.dev.dao;

import com.dev.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserDao {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;//发现服务功能

    public User queryUserById(Long id){
        // 根据服务名称，获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service-0301");
        ServiceInstance serviceInstance = instances.get(0); //目前已知只有一个
        //提供者, 直接取出. 如果多个,需要轮询算法,做负载均衡
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String baseUrl = "http://"+host+":"+port+"/user/";
//        String url = "http://localhost:8081/user/" + id;//硬编码被替代
        return this.restTemplate.getForObject(baseUrl + id, User.class);
    }

    /*
    这里单独示例，eureka在微服务中的作用原理，后续会进行优化整合
     */
}