package com.example.proxy.cglib;

/**
 * @author jameszhou
 */
public class Person {

    public void sayHello() {
        System.out.println("hello word!");
    }

    public String sendMessage(String message) {
        System.out.println(message);
        return "success";
    }
}
