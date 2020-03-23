package com.example.demo.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 2020/3/23
 *
 * @author wuzhanhao
 * <p>
 * description:
 */
@Service
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * @param key
     * @param value      json字符串
     * @param expireTime 毫秒
     * @return 缓存成功失败
     */
    public boolean set(String key, String value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set( key, value );
            // 如果缓存时间大于0,则需要缓存
            if (expireTime > 0) {
                redisTemplate.expire( key, expireTime, TimeUnit.MILLISECONDS );
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }



    /**
     * @param key
     * @return 获取redis json对象
     */
    public String get(String key) {
        String result = null;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        result = operations.get( key );
        return result;
    }

    /**
     * 根据key删除value
     *
     * @param key
     */
    public void remove(String key) {
        if (hasKey( key )) {
            redisTemplate.delete( key );
        }
    }

    /**
     * 匹配删除key
     *
     * @param pattern
     */
    public void removePattern(String pattern) {
        Set<String> keys = redisTemplate.keys( pattern );
        if (keys.size() > 0)
            redisTemplate.delete( keys );
    }


    /**
     * 判断是否存在key
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey( key );
    }


}
