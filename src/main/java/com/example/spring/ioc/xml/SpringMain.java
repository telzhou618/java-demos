package com.example.spring.ioc.xml;

public class SpringMain {
    public static void main(String[] args) throws Exception {
        // 创建SimpleBeanFactory
        BeanFactory factory = new SimpleBeanFactory();

        // 通过SimpleBeanFactoryReader加载bean定义
        SimpleBeanFactoryReader reader = new SimpleBeanFactoryReader(factory);
        reader.loadBeanDefinitions("/Users/zhougaojun/dxy/github/java-demos/src/main/java/com/example/spring/ioc/xml/beans.xml");

        // 从SimpleBeanFactory获取HelloWorld bean
        HelloWorld bean = (HelloWorld) factory.getBean("HelloWorld");
        bean.sayHello();
    }
}
