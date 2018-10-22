package com.dev.service;

import com.dev.mapper.UserMapper;
import com.dev.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        //为了演示超时现象,随机休眠一段时间
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.userMapper.selectByPrimaryKey(id);
    }
}