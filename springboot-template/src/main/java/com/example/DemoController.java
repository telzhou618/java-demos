package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jameszhou
 */
@RestController
public class DemoController {

    @RequestMapping
    public String index() {
        return "hello world!";
    }
}
