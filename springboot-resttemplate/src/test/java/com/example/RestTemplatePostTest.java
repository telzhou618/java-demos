package com.example;

import com.example.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhougaojun
 */
@Slf4j
public class RestTemplatePostTest {

    private static RestTemplate restTemplate;
    private static final String URL = "http://localhost:8080";

    @BeforeClass
    public static void beforeClass() {
        restTemplate = new RestTemplate();
    }

    /**
     * 表单提交,站位符传参
     */
    @Test
    public void postForObject1() {
        String result = restTemplate.postForObject(URL + "/user/form/add?id={0}&username={1}", null, String.class, 1, "zhangsan");
        log.info(result);
    }

    /**
     * 表单提交,命名传参
     */
    @Test
    public void postForObject2() {
        Map<String, String> form = new HashMap<>(2);
        form.put("id", "1");
        form.put("username", "zhangsan");
        String result = restTemplate.postForObject(URL + "/user/form/add?id={id}&username={username}", null, String.class, form);
        log.info(result);
    }

    /**
     * 表单提交,URI 传参
     */
    @Test
    public void postForObject3() {
        URI uri = UriComponentsBuilder.fromHttpUrl(URL + "/user/form/add")
                .queryParam("id", 1)
                .queryParam("username", "zhangsan")
                .build().toUri();
        String result = restTemplate.postForObject(uri, null, String.class);
        log.info(result);
    }

    /**
     * 表单提交,HttpEntity 方式
     */
    @Test
    public void postForObject4() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("id", "1");
        form.add("username", "tom");
        HttpEntity entity = new HttpEntity(form, headers);
        String result = restTemplate.postForObject(URL + "/user/form/add", entity, String.class);
        log.info(result);
    }

    /**
     * JSON 对象提交，默认application/json,服务提供方加 @RequestBody
     */
    @Test
    public void postForObject5() {
        User user = new User().setId(1).setUsername("tom");
        String result = restTemplate.postForObject(URL + "/user/json/add", user, String.class);
        log.info(result);
    }

    /**
     * JSON 对象提交，HttpEntity方式，application/json 服务提供方加 @RequestBody
     */
    @Test
    public void postForObject6() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        User user = new User().setId(1).setUsername("tom");
        HttpEntity entity = new HttpEntity(user, headers);
        String result = restTemplate.postForObject(URL + "/user/json/add", entity, String.class);
        log.info(result);
    }

    /**
     * 返回 ResponseEntity
     */
    @Test
    public void postForObject7() {
        User user = new User().setId(1).setUsername("tom");
        ResponseEntity<User> responseEntity = restTemplate.postForEntity(URL + "/user/json/add", user, User.class);
        log.info(""+responseEntity.getStatusCode());
        log.info(""+responseEntity.getStatusCodeValue());
        log.info(responseEntity.getBody().toString());
    }
}
