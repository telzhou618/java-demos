package com.example.config;

import com.example.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jameszhou
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public Result runtimeException(HttpServletRequest request, RuntimeException e) {
        log.error("error -> {}", e.getMessage(), e);
        return Result.failure(500, "系统繁忙");
    }
}
