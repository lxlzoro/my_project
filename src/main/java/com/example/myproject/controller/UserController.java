package com.example.myproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private final static Logger logger= LoggerFactory.getLogger(UserController.class);
    /**
     * lxl's first springboot hello world
     * @return
     */
    @RequestMapping("hello")
    public String showhello() {
        logger.info("新项目启动ing......");
        return "hello lxl,start your first Spring Boot";
    }

}
