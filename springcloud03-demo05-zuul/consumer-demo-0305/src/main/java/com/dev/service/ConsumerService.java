package com.dev.service;

import com.dev.client.UserFeignClient;
import com.dev.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerService {

    private Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public List<User> queryUsers(Long... ids){
        ArrayList<User> users = new ArrayList<>();
        for (Long id : ids) {
            long begin = System.currentTimeMillis();
            User user = userFeignClient.remoteQueryUser(id);
            long end = System.currentTimeMillis();
            logger.debug("用时==============> :{}",end-begin);
            users.add(user);
        }
        return users;
    }

}
