package com.example.demo;

import com.example.demo.builder.SimpleUrlBuilder;
import com.example.demo.proxy.RestTemplateProxy;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

public class RestTemplateTest {

    private RestTemplateProxy restTemplateProxy;

    @Before
    public void init() {
        restTemplateProxy = new RestTemplateProxy(new RestTemplate());
    }

    Function<String, Data> covertFunction = (a) -> {
        Data data = new Data();
        JsonObject jsonObject = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonObject();
        data.setArea(jsonObject.get("area").getAsString());
        data.setCity(jsonObject.get("city").getAsString());
        data.setCountry(jsonObject.get("county").getAsString());
        data.setIp(jsonObject.get("ip").getAsString());
        data.setRegion(jsonObject.get("region").getAsString());
        return data;
    };

    @Test
    public void test1() {
        String url = SimpleUrlBuilder.create("http://ip.taobao.com/service/getIpInfo.php?")
                .addParam("ip","79.223.108.42").build();
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
