package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 2020/3/10
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      Redis基本方法，get和set
 */
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }
    public void set(String key,String value){
        redisTemplate.opsForValue().set(key, value);
    }
}
