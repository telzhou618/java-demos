package com.example.controloller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author jameszhou
 */
@Slf4j
@RestController
public class TestController {

    @RequestMapping("/date")
    public String test(Date date) {
        log.info("日期:date = {}", date);
        return HttpStatus.OK.toString();
    }
}
