package com.demo.controller;

import com.demo.entitry.Post;
import com.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhougaojun
 * @date: 2019/05/21
 * @description:
 */
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 获取点赞数前100条数据
     * @return
     */
    public List<Post> listVotesTop(){
        return postService.getPostTopByVotes(100);
    }
}
