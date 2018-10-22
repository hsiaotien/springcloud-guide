package com.dev.controller;

import com.dev.pojo.User;
import com.dev.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping
    public List<User> queryUsers(@RequestParam("ids") Long... ids){
        return consumerService.queryUsers(ids);
    }
}
