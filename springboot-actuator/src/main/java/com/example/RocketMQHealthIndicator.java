package com.example;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/** 自定义健康检查
 * @author jameszhou
 */
@Component
public class RocketMQHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check();
        if(errorCode == 200){
            return Health.up().build();
        }else {
            return Health.down().withDetail("errorCode",errorCode).build();
        }
    }

    private int check(){
        return 500;
    }
}
