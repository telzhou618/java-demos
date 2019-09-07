package com.example.demo.mapper;

import com.example.demo.entity.PostRecom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * PostRecomMapper
 *
 * @author: zhougaojun
 * @date: 2019/07/23
 */
public interface PostRecomMapper extends  tk.mybatis.mapper.common.BaseMapper<PostRecom>, MySqlMapper<PostRecom>, IdsMapper<PostRecom>, ConditionMapper<PostRecom>, ExampleMapper<PostRecom> {

    @Select("update jute_post_recom set user_id=2 , pos=2 where post_id in (${postIds})")
    List<PostRecom> findByPostIdIn(@Param("postIds") String postIds);
}
