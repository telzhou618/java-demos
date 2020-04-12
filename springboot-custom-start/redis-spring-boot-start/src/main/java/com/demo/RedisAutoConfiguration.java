package com.demo;

import com.demo.config.RedisProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * @author zhougaojun
 */
@Slf4j
@Configuration
@ConditionalOnClass(Jedis.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Jedis jedis(RedisProperties redisProperties) {
        if (log.isDebugEnabled()) {
            log.debug("redisProperties = {}", redisProperties);
        }
        Jedis jedis = new Jedis(redisProperties.getHost(), redisProperties.getPort());
        if (!StringUtils.isEmpty(redisProperties.getPassword())) {
            jedis.auth(redisProperties.getPassword());
        }
        jedis.select(redisProperties.getIndex());
        return jedis;
    }
}
