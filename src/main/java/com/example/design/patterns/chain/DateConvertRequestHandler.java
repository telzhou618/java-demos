package com.example.design.patterns.chain;

/**
 * @author zhougaojun
 * @since 2021/12/9
 */
public class DateConvertRequestHandler extends RequestHandler {

    @Override
    void handler(String str) {
        System.out.println("日期转换处理");
        if (getNextHandler() != null) {
            getNextHandler().handler(str);
        }
    }
}
