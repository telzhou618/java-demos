package com.example.mapper;

import com.example.SpringTests;
import com.example.entity.UserArea;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

class UserAreaMapperTest extends SpringTests {

    @Autowired
    private UserAreaMapper userAreaMapper;

    @Test
    public void add() {
        UserArea userArea = new UserArea().setUserId(2).setAreaId(3);
        System.out.println(userAreaMapper.insertSelective(userArea));
    }

    @Test
    public void select() {
        UserArea userArea = new UserArea().setUserId(2).setAreaId(3);
        System.out.println(userAreaMapper.select(userArea));
    }

    @Test
    public void selectIn() {
        Example example = new Example(UserArea.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("userId", Lists.newArrayList(1,2,3));
        System.out.println(userAreaMapper.selectByExample(example));
    }
}