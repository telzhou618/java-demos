package com.example.config;

import com.alibaba.fastjson.JSON;
import com.example.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/** 增强 response 输出
 * @author jameszhou
 */
@Slf4j
@ControllerAdvice
public class BaseResponseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Result result;
        if (body instanceof Result) {
            result = (Result) body;
        } else {
            result = Result.success(body);
        }
        if (result.isSuccess()) {
            log.debug("Response data -> {}", JSON.toJSONString(body));
        } else {
            log.error("Response error -> {}", result);
        }
        return result;
    }
}
