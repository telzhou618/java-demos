package com.example.design.patterns.proxy.cglib;

/**
 * @author jameszhou
 */
public class Main {
    public static void main(String[] args) {
        CglibProxyFactory proxyFactory = new CglibProxyFactory(new Person());
        Person person = (Person) proxyFactory.getProxy();
        person.sayHello();
    }
}
