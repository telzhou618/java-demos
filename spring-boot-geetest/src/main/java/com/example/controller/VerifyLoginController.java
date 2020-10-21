package com.example.controller;

import com.example.common.GTClientType;
import com.example.common.GTValidate;
import com.example.common.LoginGTCondition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * 使用post方式，返回验证结果, request表单中必须包含challenge, validate, seccode
 * @author zhougaojun
 */
@RestController
public class VerifyLoginController {

    @GTValidate(clientType = GTClientType.WEB, conditionalClass = LoginGTCondition.class)
    @RequestMapping("/gt/ajax-validate")
    public Map<String, Object> doPost(HttpServletRequest request,
                                      HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> data = new HashMap<>(2);
        data.put("status", "success");
        data.put("message", "登录成功!");
        return data;
    }
}
