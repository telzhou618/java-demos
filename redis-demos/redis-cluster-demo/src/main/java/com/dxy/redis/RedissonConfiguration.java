package com.dxy.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author: zhougaojun
 * @date: 2019/05/29
 * @description:
 */
@Configuration
public class RedissonConfiguration {


    @Bean(destroyMethod = "shutdown")
    public RedissonClient reisson() throws IOException {
        Config config = Config.fromYAML(new ClassPathResource("redisson.yml").getInputStream());
        return Redisson.create(config);
    }
}
