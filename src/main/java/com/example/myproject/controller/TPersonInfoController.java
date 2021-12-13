package com.example.myproject.controller;

import com.example.myproject.entity.TPersonInfo;
import com.example.myproject.service.TPersonInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TPersonInfoController {
    private final static Logger logger = LoggerFactory.getLogger(TPersonInfoController.class);

    @Autowired
    private TPersonInfoService tPersonInfoService;

    /**
     * lxl's first springboot hello world
     *
     * @return
     */
    @RequestMapping("hello")
    public String showhello() {
        logger.info("新项目启动ing......");
        return "hello lxl,start your first Spring Boot";
    }

    @RequestMapping("/findAll")
    public List<TPersonInfo> getPersonInfoList() {
        return tPersonInfoService.getPersonInfoList();
    }

}
