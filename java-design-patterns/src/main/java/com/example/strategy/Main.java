package com.example.strategy;

/**
 * @author jameszhou
 */
public class Main {

    public static void main(String[] args) {

        HashStrategy hashStrategy = new MD5HashStrategy();
        Context context = new Context(hashStrategy);
        System.out.println(context.hash("123456"));

        // 改变 hash 策略
        context.setHashStrategy(new SHA1HashStrategy());
        System.out.println(context.hash("123456"));

        // 代理增强hash算法,增加固定前缀
        HashStrategyProxy hashStrategyProxy = new HashStrategyProxy(hashStrategy,"prex_");
        context.setHashStrategy(hashStrategyProxy);
        System.out.println(context.hash("123456"));
    }
}
