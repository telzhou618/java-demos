package com.example.entity;

import com.example.common.MyGenId;
import lombok.Data;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhougaojun
 */
@Data
@Accessors(chain = true)
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @KeySql(genId = MyGenId.class)
    private Long id;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "total_money")
    private Double totalMoney;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "modified_time")
    private Date modifiedTime;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

}
