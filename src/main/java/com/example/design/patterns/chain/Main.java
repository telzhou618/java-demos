package com.example.design.patterns.chain;

/**
 * @author zhougaojun
 * @since 2021/12/9
 */
public class Main {

    public static void main(String[] args) {
        RequestHandler handler = new ParamValidatorRequestHandler();
        RequestHandler handler1 = new StringTrimRequestHandler();
        RequestHandler handler2 = new DateConvertRequestHandler();

        handler.setNextHandler(handler1);
        handler1.setNextHandler(handler2);
        handler.handler("Hello");
    }
}
