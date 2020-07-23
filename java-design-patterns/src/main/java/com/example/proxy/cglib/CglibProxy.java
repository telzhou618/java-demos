package com.example.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 动态代理,可以代理普通类
 *
 * @author jameszhou
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置代理: method = " + method.getName() + ",params = " + parseParams(objects));
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("后置代理: result = " + result);
        return result;
    }

    /**
     * 解析参数
     *
     * @param objects 参数列表
     * @return 参数解析结果
     */
    private String parseParams(Object[] objects) {
        if (objects == null || objects.length == 0) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        for (Object object : objects) {
            buffer.append(object.toString());
        }
        return buffer.toString();
    }
}
