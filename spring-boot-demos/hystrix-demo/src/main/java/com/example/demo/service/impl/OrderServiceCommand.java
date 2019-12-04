package com.example.demo.service.impl;

import com.example.demo.bean.Order;
import com.example.demo.service.OrderService;
import com.netflix.hystrix.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhougaojun
 * @date 2019/12/04
 */
@Slf4j
public class OrderServiceCommand extends HystrixCommand<Order> {

    private OrderService orderService;
    private Integer orderId;

    public OrderServiceCommand(OrderService orderService, Integer orderId) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ThreadPoolTestGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("testCommandKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(orderId + ""))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withExecutionTimeoutInMilliseconds(5000)
                )
                .andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.Setter()
                                .withMaxQueueSize(10)   //配置队列大小
                                .withCoreSize(2)    // 配置线程池里的线程数
                )
        );
        this.orderService = orderService;
        this.orderId = orderId;

    }

    @Override
    protected Order run() {
        return orderService.getOrder(orderId);
    }

    @Override
    protected Order getFallback() {
        return new Order().setSkuName("失败的商品");
    }
}
