package com.example.design.patterns.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** JDK 动态代理,代理类必须实现接口
 * @author jameszhou
 */
public class JdkDynamicProxyFactory implements InvocationHandler {

    /**
     * 代理目标
     */
    private final Object target;

    public JdkDynamicProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return  Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("业务方法执行前...");
        Object result = method.invoke(target, args);
        System.out.println("业务方法执行后...");
        return result;
    }
}
