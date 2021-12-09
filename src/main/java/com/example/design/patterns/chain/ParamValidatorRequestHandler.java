package com.example.design.patterns.chain;

import cn.hutool.core.lang.Assert;

/**
 * @author zhougaojun
 * @since 2021/12/9
 */
public class ParamValidatorRequestHandler extends RequestHandler {

    @Override
    void handler(String str) {
        System.out.println("参数验证");
        Assert.notBlank(str);
        if (getNextHandler() != null) {
            getNextHandler().handler(str);
        }
    }
}
