package com.huayu.RedisUtils;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

public class RedisConnRef {
    /**
     * 该类已经注册到spring的bean大工厂中
     * */
    //提供set方法
    public void setConnectionFactory(JedisConnectionFactory connectionFactory) {
        //调用RedisCache类中的静态方法
        RedisCache.setJedisConnectionFactory(connectionFactory);
    }
}
