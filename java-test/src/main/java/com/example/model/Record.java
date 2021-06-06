package com.example.model;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhougaojun
 */
public final class Record {

    private Map<String, Object> map;

    public Record(int size) {
        this.map = new HashMap<>(size);
    }

    public Record() {
        this.map = new HashMap<>();
    }

    public Record set(String name, Object value) {
        map.put(name, value);
        return this;
    }

    public Object get(String name) {
        return map.get(name);
    }

    public Integer getInt(String name) {
        return (Integer) get(name);
    }

    public String getStr(String name) {
        return (String) get(name);
    }

    public String toJSON() {
        return JSON.toJSONString(map);
    }

    public static Record of(String key, Object value) {
        return new Record().set(key, value);
    }

    public static Record of(String key1, Object value1,
                            String key2, Object value2) {
        return new Record().set(key1, value1)
                .set(key2, value2);
    }


    public static void main(String[] args) {
        Record record = new Record(2)
                .set("name", "zhangsan")
                .set("age", 18);
        System.out.println(record.getStr("name"));
        System.out.println(record.getInt("age"));
        System.out.println(record.get("name"));
        System.out.println(record.toJSON());

        System.out.println(Record.of("name", "zs", "age", 18));
    }
}
