package com.example.common;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhougaojun
 */
@Component
public class LoginGTCondition implements GTCondition {

    @Override
    public boolean condition(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }
}
