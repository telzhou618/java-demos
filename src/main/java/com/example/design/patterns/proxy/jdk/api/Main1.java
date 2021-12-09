package com.example.design.patterns.proxy.jdk.api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhougaojun
 */
public class Main1 {

    /**
     * 给接口生成代理对象
     */
    public static void main(String[] args) {
        Class aClass = UserClient.class;
        UserClient userClient = (UserClient) Proxy.newProxyInstance(aClass.getClassLoader(), new Class[]{aClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                // 继承自object类的方法无需代理
                if (Object.class.equals(method.getDeclaringClass())) {
                    try {
                        return method.invoke(this, args);
                    } catch (Throwable t) {
                        throw new RuntimeException();
                    }
                }

                System.out.println("执行前");
                //Object object = method.invoke(aClass, args);
                String value = method.getAnnotation(Url.class).value();
                System.out.println("执行方法,url = " + value);
                System.out.println("执行后");
                return null;
            }
        });
        userClient.getUsername(123);
        System.out.println(userClient.toString());
    }


}
