package com.example.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhougaojun
 */
@Data
@Accessors(chain = true)
@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    @Column(name = "user_name")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Column(name = "password")
    private String password;

}
