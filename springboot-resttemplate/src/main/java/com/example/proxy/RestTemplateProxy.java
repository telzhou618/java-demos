package com.example.proxy;

import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

/**
 * RestTemplateProxy
 *
 * @author zhougaojun
 * @date 2019/07/28
 */
@AllArgsConstructor
public class RestTemplateProxy {

    private RestTemplate restTemplate;

    public <T> T getForObject(String url, Class<T> responseType) {
        return restTemplate.getForObject(url, responseType);
    }

    public <T> T getForObject(String url, Function<String, T> convertFunction) {
        String result = restTemplate.getForObject(url, String.class);
        return convertFunction.apply(result);
    }

    public <T> T postForObject(String url, Object request, Class<T> responseType) {
        return restTemplate.postForObject(url, request, responseType);
    }

    public <T> T postForObject(String url, Object request, Function<String, T> convertFunction) {
        String result = restTemplate.postForObject(url, request, String.class);
        return convertFunction.apply(result);
    }
}
