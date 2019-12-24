package com.aaa.lee.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;
/**
 * @Company AAA软件教育
 * @Author  王向阳
 * @Date Create in  2019/12/21  15:42
 * @Description
 */

@Service
public class RedisService {

    @Autowired
    private JedisCluster jedisCluster;


    /**
     * 查询redis中的数据
     * @param key
     * @return
     */
    public String get(String key){
        String s = jedisCluster.get(key);
        return s;
    }

    /**
     * 添加数据
     * @param key
     * @param value
     * @return
     */
    public  String set(String key,String value){
        return jedisCluster.set(key,value);
    }

    /**
     * 删除redis中的数据
     * @param key
     * @return
     */
    public Integer del(String key){
        return del(key);
    }

    /**
     * 设置redis缓存的失效时间
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(String key,Integer seconds){
        return jedisCluster.expire(key,seconds);
    }
}
