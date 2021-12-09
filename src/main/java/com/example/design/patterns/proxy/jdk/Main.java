package com.example.design.patterns.proxy.jdk;

/**
 * @author jameszhou
 */
public class Main {

    public static void main(String[] args) {

        JdkDynamicProxyFactory proxyFactory = new JdkDynamicProxyFactory(new Dog());
        Animal animal = (Animal) proxyFactory.getProxy();
        animal.test();
    }
}
