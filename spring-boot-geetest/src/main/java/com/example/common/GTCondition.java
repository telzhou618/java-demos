package com.example.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhougaojun
 */
public interface GTCondition {

    /**
     * 极验执行条件
     *
     * @param request
     * @param response
     * @return
     */
    boolean condition(HttpServletRequest request, HttpServletResponse response);
}
