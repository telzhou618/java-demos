package com.example;

import com.example.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhougaojun
 */
@ComponentScan("com.example.bean")
public class ComponentScanSpringBeanDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ComponentScanSpringBeanDemo.class);
        System.out.println(ctx.getBean(Student.class).toString());
    }
}
