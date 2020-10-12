package com.example.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zhougaojun
 */
@Data
@Accessors(chain = true)
@Table(name = "tb_user_area")
public class UserArea implements Serializable {

    @Id
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "area_id")
    private Integer areaId;
}
