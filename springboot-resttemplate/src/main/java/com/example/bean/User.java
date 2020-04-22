package com.example.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhougaojun
 */
@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    private String username;
}
