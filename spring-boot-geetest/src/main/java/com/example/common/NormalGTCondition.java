package com.example.common;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 默认执行极验条件,需要进行验证
 * @author zhougaojun
 */
@Component
public class NormalGTCondition implements GTCondition {

    @Override
    public boolean condition(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }
}
