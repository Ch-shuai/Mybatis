package com.example.demo.service.impl;

import com.example.demo.entity.po.Material;
import com.example.demo.service.RedisService;
import com.example.demo.utils.JsonUtils;
import com.example.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 2020/3/10
 *
 * @author wuzhanhao
 * <p>
 * description:
 */

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisUtils redisUtils;

    @Override
    public String getData() {
        Material material = new Material();
        material.setName("redis-test");
        material.setCreator("wuzhanhao");
        material.setCreateTime(new Date());
        material.setCreatorId(2L);
        redisUtils.set("Material-one", JsonUtils.objToJSONString(material));
        return redisUtils.get("Material-one");
    }
}
