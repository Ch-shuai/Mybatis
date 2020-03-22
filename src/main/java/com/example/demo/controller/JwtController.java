package com.example.demo.controller;

import com.example.demo.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 2020/3/9
 *
 * @author wuzhanhao
 */
@RestController
@RequestMapping("/jwt")
public class JwtController {
    /**
     * 生成token
     */
    @ApiOperation("生成Token")
    @RequestMapping("")
    @PostMapping
    public String getToken() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1","123aaa");
        String token = JwtUtils.generateToken(map);
        Claims claims = JwtUtils.verifyJwt(token);
        System.out.println(claims);
        return token;
    }

}
