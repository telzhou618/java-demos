package com.example;

import com.example.bean.User;
import com.example.config.UserImportSelector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author zhougaojun
 */
@Import(UserImportSelector.class)
public class ImportSelectorSpringBeanDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ImportSelectorSpringBeanDemo.class);
        System.out.println(ctx.getBean(User.class).toString());
    }
}
