package com.zzn.mall.service;

/**
 * @ClassName RedisService
 * @Author zhangzhaonian
 * @Description redis操作（对象和数字都以JSON格式存储）
 * @CreateTime 2022/4/6-21:42
 **/

public interface RedisService {

    /**
     * 存储数据
     * @param key
     * @param value
     */
    void set(String key,String value);

    /**
     * 获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置超时时间
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key,long expire);

    /**
     * 删除数据
     * @param key
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key
     * @param delta 自增步长
     * @return
     */
    Long increment(String key,long delta);

}
