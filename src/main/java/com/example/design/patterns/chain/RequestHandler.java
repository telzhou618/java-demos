package com.example.design.patterns.chain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhougaojun
 * @since 2021/12/9
 */
@Getter
@Setter
public abstract class RequestHandler {

    /**
     * 下一个处理器
     */
    private RequestHandler nextHandler;

    abstract void handler(String str);
}
