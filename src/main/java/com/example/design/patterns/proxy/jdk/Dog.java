package com.example.design.patterns.proxy.jdk;

/**
 * @author jameszhou
 */
public class Dog implements Animal {
    @Override
    public void run() {
        System.out.println("dog 会跑!");
    }
}
