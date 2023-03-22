package com.example.spring.ioc.xml;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class SimpleBeanFactoryReader {

    private BeanFactory factory;

    public SimpleBeanFactoryReader(BeanFactory factory) {
        this.factory = factory;
    }

    public void loadBeanDefinitions(String filename) throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filename);
        NodeList beans = doc.getElementsByTagName("bean");
        for (int i = 0; i < beans.getLength(); i++) {
            Element bean = (Element) beans.item(i);
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            Object obj = Class.forName(className).newInstance();
            factory.registerBean(name, obj);
        }
    }
}
