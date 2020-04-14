package com.example.common;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author jameszhou
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Result {

    private int code;
    private String message;
    private boolean success;
    private Object data;

    public static Result success() {
        return success(null);
    }

    public static Result success(Object data) {
        return new Result().setCode(200).setSuccess(true).setData(data);
    }

    public static Result failure(String message) {
        return failure(500, message);
    }

    public static Result failure(int code, String message) {
        return new Result().setCode(code).setSuccess(false).setMessage(message);
    }

    public String toJSON() {
        return JSON.toJSONString(this);
    }
}
