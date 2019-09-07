package com.example.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * PostRecom
 *
 * @author: zhougaojun
 * @date: 2019/07/23
 */
@Data
@Accessors(chain = true)
@Table(name = "jute_post_recom")
public class PostRecom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "created_time", updatable = false)
    private Date createdTime;

    @Column(name = "created_time")
    private Date modifiedTime;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "pos")
    private Integer pos;
}
