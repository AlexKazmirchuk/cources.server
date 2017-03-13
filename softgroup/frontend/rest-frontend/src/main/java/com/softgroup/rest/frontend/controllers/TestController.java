package com.softgroup.rest.frontend.controllers;

import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.router.impl.FirstRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author AlexKazmirchuk
 * @since 06.03.17.
 */

@RestController
public class TestController {

    @Resource
    private DataMapper mapper;

    @Autowired
    private FirstRouter firstRouter;

    @RequestMapping("/test")
    public String test(){
        return firstRouter.getName() + " was autowired and works!";
    }
}
