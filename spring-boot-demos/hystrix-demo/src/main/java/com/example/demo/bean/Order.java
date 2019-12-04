package com.example.demo.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhougaojun
 * @date 2019/12/03
 */
@Data
@Accessors(chain = true)
public class Order {

    private int orderId;
    private String skuName;
    private double amount;
}
