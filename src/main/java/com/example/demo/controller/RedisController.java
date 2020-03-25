package com.example.demo.controller;

import com.example.demo.service.redis.RedisService;
import com.sun.org.apache.regexp.internal.RE;
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
        redisService.set("kkk","sdsa", Long.valueOf(60*3));

        String s = redisService.get("kkk");
        return s;
    }

}
