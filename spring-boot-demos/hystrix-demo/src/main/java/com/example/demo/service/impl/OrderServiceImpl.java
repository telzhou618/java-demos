package com.example.demo.service.impl;

import com.example.demo.bean.Order;
import com.example.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhougaojun
 * @date 2019/12/04
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {


    @Override
    public Order getOrder(int orderId) {
        log.info("线程名称：「{}」orderId = {}", Thread.currentThread().getName(), orderId);
        return new Order().setOrderId(orderId).setSkuName("商品名称").setAmount(100);
    }
}
