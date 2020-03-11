package com.example.demo.controller;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2020/3/10
 *
 * @author wuzhanhao
 * <p>
 * description:
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisService redisService;

    @Autowired
    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @RequestMapping("")
    public String getDataFromRedis(){
       String str = redisService.getData();
       return str;
    }
}
