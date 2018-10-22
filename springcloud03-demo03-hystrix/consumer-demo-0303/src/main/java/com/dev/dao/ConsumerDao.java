package com.dev.dao;

import com.dev.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ConsumerDao {

    //用于测试熔断,配置日志
    private Logger logger = LoggerFactory.getLogger(ConsumerDao.class);

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "remoteQueryUserFallBack")
    public User remoteQueryUser(Long id){

        /*List<ServiceInstance> instances = discoveryClient.getInstances("user-service-0302");
        ServiceInstance serviceInstance = instances.get(0); //目前已知只有一个
        //提供者, 直接取出. 如果多个,需要轮询算法,做负载均衡
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String baseUrl = "http://"+host+":"+port+"/user/";*/

        String baseUrl = "http://user-service-0303/user/";
        long begin = System.currentTimeMillis();
        User user = restTemplate.getForObject(baseUrl + id, User.class);//restTemplate被封装替换掉了
        long end = System.currentTimeMillis();
        //记录访问用时
        logger.info("远程访问用时:{}",end-begin);
        return user;
    }

    public User remoteQueryUserFallBack(Long id){
        User user = new User();
        user.setId(id);
        user.setName("用户信息查询出现异常！");
        return user;
    }

    /**
    熔断服务降级的原理和配置，查看文档或者desc.md
     */



	/**
     *
     * robbin 原理
	 * 修改调用方式，不再手动获取ip和端口，而是直接通过服务名称调用：
     *
     * 引入robbin负载均衡，负载均衡原理详情查看启动类的注释，
     *
     * 需要注意的是重试机制引入需要导入依赖以及配置.
     *
     * 补充： 如何配置重试算法，配置算法即可，查看test示例
     *
     * 此外，eureka内置了robbin,即引入eureka就引入了robbin的依赖，理论上只需要在restemplate
     * 注解@LoadBalanced即可，其他的默认配置属性就可以完成基本的负载均衡功能。
     *
     * 但是，需要优化属性的配置，
     * 包含重试机制的开启(默认已开），负载均衡策略机制指定，以及必要时要配置负载均衡策略的算法。
     *
     * 就可以使用负载均衡的能力，直接根据serverId查找可用服务实例。
     *
     * 着重理解，
     * 负载均衡的双层map,第一层key及时serverId,第二层key就是instanceId,
     * value就是对应的ip和port。 理解这种设计的思路来实现负载均衡。
     */

}
