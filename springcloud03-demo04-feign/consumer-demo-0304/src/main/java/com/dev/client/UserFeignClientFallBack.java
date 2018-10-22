package com.dev.client;

import com.dev.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallBack implements UserFeignClient {
    @Override
    public User remoteQueryUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户查询出现异常! 来自feign对hystrix的支持,1配置开启feign支持功能,2编写熔断fallback函数 3在feign代理接口上标注");
        return user;
    }
}
