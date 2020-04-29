package com.example.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/permission")
@RestController
@Api(description = "使用shiro进行权限管理")
public class PermissionController {

    /**
     * 使用shiro框架来对用户的当前权限进行判断，根据权限不同展示不同的东西
     *  shiro的验证 --- 》 SecurityManager - 》Reaml --》
     */

    @GetMapping("/test")
    public String test(){
        return "hello";
    }
}
