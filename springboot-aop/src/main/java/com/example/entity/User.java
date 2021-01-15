package com.example.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author zhougaojun
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;

}
