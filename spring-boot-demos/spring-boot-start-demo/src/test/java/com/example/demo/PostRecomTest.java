package com.example.demo;

import com.example.demo.entity.PostRecom;
import com.example.demo.mapper.PostRecomMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

/**
 * PostRecomTest
 *
 * @author: zhougaojun
 * @date: 2019/07/23
 */
public class PostRecomTest extends SpringBootDemoApplicationTests {

    @Autowired
    private PostRecomMapper mapper;

    @Test
    public void test1() {
        // System.out.println(postRecomMapper.selectAll());
        // System.out.println(postRecomMapper.selectOne(new PostRecom().setPostId(1)));
      /*  Example example = Example.builder(PostRecom.class).build();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("postId", 1);
        criteria.andEqualTo("isDeleted",false);
        System.out.println(postRecomMapper.selectOneByExample(example));*/

       /* Condition condition = new Condition(PostRecom.class,true,true);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("postId", 1);
        criteria.andEqualTo("username", null);
        System.out.println(mapper.selectByCondition(condition));*/

    }

    @Test
    public void test2(){
        Example example = Example.builder(PostRecom.class).build();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("postId", 1);
        criteria.andEqualTo("username",null);
        System.out.println(mapper.selectByExample(example));
    }

    @Test
    public void test3(){
        System.out.println(mapper.selectByPrimaryKey(40));
    }

    @Test
    public void test4(){
        mapper.selectByExample(null).stream().findFirst().orElse(null);
    }

    @Test
    public void test5(){
        System.out.println(mapper.findByPostIdIn("1,2"));
    }
}
