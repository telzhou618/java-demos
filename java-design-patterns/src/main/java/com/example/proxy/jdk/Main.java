package com.example.proxy.jdk;

/**
 * @author jameszhou
 */
public class Main {

    public static void main(String[] args) {

        Animal animal = new JdkDynamicProxy(new Dog()).getProxy();
        animal.run();
    }
}
