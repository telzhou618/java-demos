package com.example;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.example.entity.Order;
import com.example.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author jameszhou
 */
@Slf4j
@SpringBootTest
class SpringTests {

    @Resource
    private OrderMapper orderMapper;
    @Autowired
    private IdGenerator idGenerator;

    @Test
    public void testAdd() {
        Order order = new Order()
                .setOrderName("包包3")
                .setTotalMoney(12000D);
        System.out.println(orderMapper.insertSelective(order));
    }

}
