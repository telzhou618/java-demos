package com.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhougaojun
 */
@Slf4j
public class RestTemplateProxyTest {

    private static RestTemplate restTemplate;
    private static RestTemplate restTemplateProxy;

    @BeforeClass
    public static void beforeClass() {
        restTemplate = new RestTemplate();
        restTemplateProxy = new RestTemplateProxy();
    }

    /**
     * RestTemplateProxy 异常测试
     */
    @Test
    public void getForObject() {
        ResponseEntity<String> result = restTemplateProxy.getForEntity("http://localhost:8080/error/500", String.class);
        log.info(result.toString());
        System.out.println("可以继续执行");
    }

    /**
     * RestTemplate 异常测试
     */
    @Test
    public void getForObject2() {
        ResponseEntity<String> result = restTemplate.getForEntity("http://localhost:8080/error/500", String.class);
        log.info(result.toString());
        System.out.println("restTemplate 异常无法继续执行");
    }
}
