package com.dxy.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhougaojun
 * @date: 2019/05/29
 * @description:
 */
@Configuration
public class JedisRedisClusterConfiguration {


    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxWaitMillis(1500);
        return jedisPoolConfig;
    }

    @Bean
    public JedisCluster jedisCluster() {
        Set<HostAndPort> nodes = new HashSet();
        nodes.add(new HostAndPort("127.0.0.1", 7000));
        nodes.add(new HostAndPort("127.0.0.1", 7001));
        nodes.add(new HostAndPort("127.0.0.1", 7002));
        nodes.add(new HostAndPort("127.0.0.1", 7003));
        nodes.add(new HostAndPort("127.0.0.1", 7004));
        nodes.add(new HostAndPort("127.0.0.1", 7005));
        JedisCluster jedisCluster = new JedisCluster(nodes, jedisPoolConfig());
        return jedisCluster;
    }
}
