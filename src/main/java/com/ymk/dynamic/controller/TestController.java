package com.ymk.dynamic.controller;

import com.ymk.dynamic.exception.ServiceException;
import com.ymk.dynamic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mkyoung
 **/
@RestController
@RequestMapping
public class TestController {


    @Autowired
    private UserService userService;

    @RequestMapping("test")
    public Object test(){
        throw new ServiceException("123");
 //       return userService.findAll();
    }


    @RequestMapping("test2")
    public Object test2(){
        return userService.findAll();
    }

}
