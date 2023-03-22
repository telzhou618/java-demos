package com.example.spring.ioc.xml;

public interface BeanFactory {
    // 通过名称获取bean
    Object getBean(String name) throws Exception;

    // 注册bean
    void registerBean(String name, Object bean);
}
