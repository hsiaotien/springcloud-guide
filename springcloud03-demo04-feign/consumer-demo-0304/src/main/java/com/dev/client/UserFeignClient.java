package com.dev.client;


import com.dev.config.FeignConfig;
import com.dev.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="user-service-0304",
        fallback = UserFeignClientFallBack.class,
        configuration = FeignConfig.class)
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User remoteQueryUser(@PathVariable("id") Long id);

}
