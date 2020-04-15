package com.example.entity;

import com.example.common.WorkOverTime;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author jameszhou
 */
@Data
public class User {

    @NotNull(message = "ID不能为空 ")
    @Min(value = 1, message = "ID最小值为1")
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 4, max = 10, message = "用户名长度必须为[4~10]")
    private String username;

    @WorkOverTime
    private Integer workTime;
}
