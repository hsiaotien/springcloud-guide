package com.dev.dao;

import com.dev.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class ConsumerDao {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    public User remoteQueryUser(Long id){

        /*List<ServiceInstance> instances = discoveryClient.getInstances("user-service-0302");
        ServiceInstance serviceInstance = instances.get(0); //目前已知只有一个
        //提供者, 直接取出. 如果多个,需要轮询算法,做负载均衡
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String baseUrl = "http://"+host+":"+port+"/user/";*/

        String baseUrl = "http://user-service-0302/user/";
        return restTemplate.getForObject(baseUrl + id, User.class);//restTemplate被封装替换掉了
    }

    /**
     * 修改调用方式，不再手动获取ip和端口，而是直接通过服务名称调用：
     *
     * 引入robbin负载均衡，负载均衡原理详情查看启动类的注释，
     *
     * 需要注意的是重试机制引入需要导入依赖以及配置.
     *
     * 补充： 如何配置重试算法，配置算法即可，查看test示例
     */

}
