package com.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.proxy.RestTemplateProxy;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

/**
 * RestTemplateTest
 *
 * @author zhougaojun
 * @date 2019/07/28
 */

public class RestTemplateTest{

    private RestTemplateProxy restTemplateProxy;

    @Before
    public void init() {
        restTemplateProxy = new RestTemplateProxy(new RestTemplate());
    }

    Function<String, Data> covertFunction = (a) -> {
        JSONObject jsonObject = JSON.parseObject(a).getJSONObject("data");
        return jsonObject.toJavaObject(Data.class);
    };

    @Test
    public void test() {
        String url = "http://ip.taobao.com/service/getIpInfo.php?ip=79.223.108.42";
        Data data = restTemplateProxy.getForObject(url, covertFunction);
        System.out.println(data);
    }


    @lombok.Data
    class Data {
        private String ip;
        private String country;
        private String area;
        private String region;
        private String city;
    }
}
