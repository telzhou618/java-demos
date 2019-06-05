package com.example.demo;

import com.cxytiandi.elasticjob.annotation.EnableElasticJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: zhougaojun
 * @date: 2019/06/05
 * @description:
 */
@EnableElasticJob
@SpringBootApplication
public class ElasticJobSpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticJobSpringBootDemoApplication.class, args);
    }

}
