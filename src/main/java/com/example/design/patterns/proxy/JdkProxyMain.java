package com.example.design.patterns.proxy;

import com.example.design.patterns.proxy.jdk.Animal;
import com.example.design.patterns.proxy.jdk.Dog;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhougaojun
 * @since 2021/12/9
 */
@Getter
@Setter
public class JdkProxyMain implements InvocationHandler {

    private final Object target;

    public JdkProxyMain(Object target) {
        this.target = target;
    }

    public static void main(String[] args) {
        JdkProxyMain jdkProxyMain = new JdkProxyMain(new Dog());
        Animal animal = (Animal) jdkProxyMain.getProxy();
        animal.test();
    }

    public Object getProxy() {
        return  Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("业务执行前");
        Object result = method.invoke(target, args);
        System.out.println("业务执行后");
        return result;
    }
}
