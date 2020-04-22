package com.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhougaojun
 */
@Slf4j
public class RestTemplateGetTest {

    private static RestTemplate restTemplate;

    @BeforeClass
    public static void beforeClass() {
        restTemplate = new RestTemplate();
    }

    /**
     * 普通GET请求
     */
    @Test
    public void getForObject1() {
        String result = restTemplate.getForObject("https://suggest.taobao.com/sug?code=utf-8&q=11", String.class);
        log.info(result);
    }

    /**
     * 占位符参数
     */
    @Test
    public void getForObject2() {
        String result = restTemplate.getForObject("https://suggest.taobao.com/sug?code={0}&q={1}", String.class, "utf-8", "iphone");
        log.info(result);
    }

    /**
     * 命名参数
     */
    @Test
    public void getForObject3() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", "utf-8");
        map.put("q", "iphone");
        String result = restTemplate.getForObject("https://suggest.taobao.com/sug?code={code}&q={q}", String.class, map);
        log.info(result);
    }

    /**
     * URI 请求
     */
    @Test
    public void getForObject4() {
        URI uri = UriComponentsBuilder.fromHttpUrl("https://suggest.taobao.com/sug")
                .queryParam("code", "utf-8")
                .queryParam("q", "手机")
                .build().toUri();
        String result = restTemplate.getForObject(uri, String.class);
        log.info(result);
    }
}
