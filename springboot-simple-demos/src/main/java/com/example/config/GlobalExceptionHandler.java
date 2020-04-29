package com.example.config;

import com.example.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/** 全局异常处理器
 * @author jameszhou
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result baseException(HttpServletRequest request, Exception e) {
        log.error("error -> {}", e.getMessage(), e);
        return Result.failure(500, "系统内部错误");
    }
}
