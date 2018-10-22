package com.dev.service;

import com.dev.client.UserFeignClient;
import com.dev.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerService {

    @Autowired
    private UserFeignClient userFeignClient;

    public List<User> queryUsers(Long... ids){
        ArrayList<User> users = new ArrayList<>();
        for (Long id : ids) {
            User user = userFeignClient.remoteQueryUser(id);
            users.add(user);
        }
        return users;
    }

}
