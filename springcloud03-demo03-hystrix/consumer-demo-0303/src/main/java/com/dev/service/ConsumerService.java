package com.dev.service;

import com.dev.dao.ConsumerDao;
import com.dev.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerService {

    @Autowired
    private ConsumerDao consumerDao;

    public List<User> queryUsers(Long... ids){
        ArrayList<User> users = new ArrayList<>();
        for (Long id : ids) {
            User user = consumerDao.remoteQueryUser(id);
            users.add(user);
        }
        return users;
    }

}
