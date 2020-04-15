package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jameszhou
 */
@Controller
public class TestController {

    @GetMapping("/freemarker/test")
    public String test(Model model) {
        model.addAttribute("id", 123);
        model.addAttribute("username", "zhangsan");
        return "test";
    }
}
