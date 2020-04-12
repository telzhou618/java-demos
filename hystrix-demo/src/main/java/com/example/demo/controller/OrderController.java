package com.example.demo.controller;

import com.example.demo.bean.Order;
import com.example.demo.service.OrderService;
import com.example.demo.service.impl.OrderServiceCommand;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhougaojun
 * @date 2019/12/03
 */
@RestController
@AllArgsConstructor
public class OrderController {


    private OrderService orderService;

    /**
     * 正常获取订单
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/get-order")
    public Order getOrder(@RequestParam(name = "orderId", defaultValue = "0") Integer orderId) {
        return orderService.getOrder(orderId);
    }

    /**
     * Hystrix 线程隔离
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/get-order2")
    public Order getOrde2(@RequestParam(name = "orderId", defaultValue = "0") Integer orderId) {
        return new OrderServiceCommand(orderService, orderId).execute();
    }
}
