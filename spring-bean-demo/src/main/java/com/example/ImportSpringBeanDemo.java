package com.example;

import com.example.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author zhougaojun
 */
@Import(User.class)
public class ImportSpringBeanDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ImportSpringBeanDemo.class);
        System.out.println(ctx.getBean(User.class).toString());
    }
}
