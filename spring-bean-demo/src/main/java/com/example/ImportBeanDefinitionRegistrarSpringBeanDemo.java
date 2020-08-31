package com.example;

import com.example.bean.User;
import com.example.config.UserImportBeanDefinitionRegistrar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author zhougaojun
 */
@Import(UserImportBeanDefinitionRegistrar.class)
public class ImportBeanDefinitionRegistrarSpringBeanDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ImportBeanDefinitionRegistrarSpringBeanDemo.class);
        System.out.println(ctx.getBean(User.class).toString());
    }
}
