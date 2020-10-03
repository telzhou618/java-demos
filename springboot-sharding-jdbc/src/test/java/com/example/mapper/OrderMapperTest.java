package com.example.mapper;

import com.alibaba.fastjson.JSON;
import com.example.SpringTests;
import com.example.entity.Order;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

class OrderMapperTest extends SpringTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void add() {
        Order order = new Order()
                .setOrderName("包包3")
                .setTotalMoney(12000D);
        System.out.println(orderMapper.insertSelective(order));
    }

    @Test
    public void listAll() {
        System.out.println(JSON.toJSONString(orderMapper.selectAll()));
    }

    @Test
    public void selectById() {
        System.out.println(JSON.toJSONString(orderMapper.selectByPrimaryKey(100000L)));
    }


    @Test
    public void select1() {
        Order order = new Order().setOrderName("包包3");
        System.out.println(JSON.toJSONString(orderMapper.select(order)));
    }

    @Test
    public void selectIn() {

        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Lists.newArrayList(100004L, 100003L));
        System.out.println(JSON.toJSONString(orderMapper.selectByExample(example)));
    }

}