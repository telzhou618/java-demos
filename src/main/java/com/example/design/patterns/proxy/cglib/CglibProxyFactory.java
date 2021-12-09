package com.example.design.patterns.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 动态代理,可以代理普通类
 *
 * @author jameszhou
 */
public class CglibProxyFactory implements MethodInterceptor {

    /**
     * 代理目标
     */
    private final Object target;
    private final Enhancer enhancer;

    public CglibProxyFactory(Object target) {
        this.target = target;
        this.enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
    }


    public Object getProxy() {
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("业务方法执行前...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("业务方法执行后...");
        return result;
    }
}
