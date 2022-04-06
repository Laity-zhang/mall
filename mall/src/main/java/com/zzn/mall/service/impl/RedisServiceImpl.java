package com.zzn.mall.service.impl;

import com.zzn.mall.service.RedisService;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisServiceImpl
 * @Author zhangzhaonian
 * @Description redis操作实现类
 * @CreateTime 2022/4/6-21:43
 **/

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存储数据
     * @param key
     * @param value
     */
    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取值
     * @param key
     * @return
     */
    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 设置超时时间
     * @param key
     * @param expire
     * @return
     */
    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key,expire, TimeUnit.SECONDS);
    }

    /**
     * 删除值
     * @param key
     */
    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 设置自增步长
     * @param key
     * @param delta 自增步长
     * @return
     */
    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key,delta);
    }
}
