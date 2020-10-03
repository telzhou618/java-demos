package com.example.mapper;

import com.example.entity.Order;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;

/**
 * @author zhougaojun
 */
public interface OrderMapper extends BaseMapper<Order>, ExampleMapper<Order> {

}
