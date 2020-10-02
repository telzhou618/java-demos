package com.example.config;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jameszhou
 */
@Configuration
public class IdGeneratorConfig {

    @Bean
    public IdGenerator creatIdGenerator(){
        return new CommonSelfIdGenerator();
    }
}

