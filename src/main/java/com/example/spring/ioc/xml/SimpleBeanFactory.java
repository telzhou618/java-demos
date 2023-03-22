package com.example.spring.ioc.xml;

import java.util.HashMap;
import java.util.Map;

public class SimpleBeanFactory implements BeanFactory {

    private Map<String, Object> beanMap = new HashMap<String, Object>();

    // 通过名称获取bean
    public Object getBean(String name) throws Exception {
        Object bean = beanMap.get(name);
        if (bean == null) {
            throw new Exception("Bean not found: " + name);
        }
        return bean;
    }

    // 注册bean
    public void registerBean(String name, Object bean) {
        beanMap.put(name, bean);
    }
}