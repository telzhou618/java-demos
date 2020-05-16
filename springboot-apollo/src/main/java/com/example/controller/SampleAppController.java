package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jameszhou
 */
@RestController
public class SampleAppController {

    @Value("${timeout:3000}")
    private Integer timeout;

    @GetMapping("/get/timeout")
    public Integer getTimeout() {
        return this.timeout;
    }
}
