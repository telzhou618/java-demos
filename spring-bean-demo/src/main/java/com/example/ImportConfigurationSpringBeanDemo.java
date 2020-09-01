package com.example;

import com.example.bean.User;
import com.example.config.UserConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/** Configuration 注册 bean
 * @author zhougaojun
 */
@Import(UserConfiguration.class)
public class ImportConfigurationSpringBeanDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ImportConfigurationSpringBeanDemo.class);
        System.out.println(ctx.getBean(User.class).toString());
    }
}
