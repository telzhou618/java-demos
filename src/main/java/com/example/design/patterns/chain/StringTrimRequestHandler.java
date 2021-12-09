package com.example.design.patterns.chain;

/**
 * @author zhougaojun
 * @since 2021/12/9
 */
public class StringTrimRequestHandler extends RequestHandler {


    @Override
    void handler(String str) {
        System.out.println("去除空格");
        // 去除空交给下一个处理器
        if (getNextHandler() != null) {
            getNextHandler().handler(str.trim());
        }
    }
}
