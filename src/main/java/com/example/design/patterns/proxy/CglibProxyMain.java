package com.example.design.patterns.proxy;

import com.example.design.patterns.proxy.cglib.Person;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhougaojun
 * @since 2021/12/9
 */
public class CglibProxyMain {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("业务执行前");
                Object invoke = methodProxy.invokeSuper(o, objects);
                System.out.println("业务执行后");
                return invoke;
            }
        });
        Person p = (Person) enhancer.create();
        p.sayHello();
    }
}
