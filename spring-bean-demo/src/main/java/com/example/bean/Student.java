package com.example.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author zhougaojun
 */
@Getter
@Setter
@Accessors(chain = true)
@ToString
@Component
public class Student implements InitializingBean {

    private Integer id;
    private String username;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.id = 1;
        this.username = "jerry";
    }
}
