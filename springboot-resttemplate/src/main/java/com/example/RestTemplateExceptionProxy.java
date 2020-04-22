package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

/**
 * @author zhougaojun
 */
public class RestTemplateExceptionProxy extends RestTemplate {

    @Override
    public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... uriVariables) {
        try {
            return super.getForEntity(url, responseType, uriVariables);
        } catch (RestClientException e) {
            return doErrorResponseEntity(e);
        }
    }
    
    @Override
    public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Map<String, ?> uriVariables) {
        try {
            return super.getForEntity(url, responseType, uriVariables);
        } catch (RestClientException e) {
            return doErrorResponseEntity(e);
        }
    }

    @Override
    public <T> ResponseEntity<T> getForEntity(URI url, Class<T> responseType) {
        try {
            return super.getForEntity(url, responseType);
        } catch (RestClientException e) {
            return doErrorResponseEntity(e);
        }
    }

    @Override
    public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Object... uriVariables) {
        try {
            return super.postForEntity(url, request, responseType, uriVariables);
        } catch (RestClientException e) {
            return doErrorResponseEntity(e);
        }
    }

    @Override
    public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) {
        try {
            return super.postForEntity(url, request, responseType, uriVariables);
        } catch (RestClientException e) {
            return doErrorResponseEntity(e);
        }
    }

    @Override
    public <T> ResponseEntity<T> postForEntity(URI url, Object request, Class<T> responseType) {
        try {
            return super.postForEntity(url, request, responseType);
        } catch (RestClientException e) {
            return doErrorResponseEntity(e);
        }
    }

    private ResponseEntity doErrorResponseEntity(RestClientException e) {
        logger.error("接口调用失败", e);
        return ResponseEntity.status(500).body("接口调用失败");
    }
}
