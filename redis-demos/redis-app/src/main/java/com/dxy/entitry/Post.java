package com.dxy.entitry;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: zhougaojun
 * @date: 2019/05/21
 * @description:
 */
@Entity
@Data
@Table(name = "tb_post")
public class Post implements Serializable {
    private static final long serialVersionUID = -4396268218135591624L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String subject;
    private String body;
    private int views; // 阅读
    private int stars; // 收藏
    private int votes; // 点赞
    private int replies; // 回复

    @Column(name = "createTime")
    private Date createTime;
    @Column(name = "modifyTime")
    private Date modifyTime;
    private boolean deleted;
}
