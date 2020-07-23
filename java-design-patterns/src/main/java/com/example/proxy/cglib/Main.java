package com.example.proxy.cglib;

/**
 * @author jameszhou
 */
public class Main {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Person person = (Person) proxy.getProxy(Person.class);
        person.sayHello();
        System.out.println("-----------------------------------");
        String result = person.sendMessage("hello");
        System.out.println(result);
    }
}
