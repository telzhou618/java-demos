package com.dxy.repository;

import com.dxy.entitry.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: zhougaojun
 * @date: 2019/05/21
 * @description:
 */
public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {

    @Query(value = "select * from tb_post where deleted = 0 order by votes desc limit ?1",nativeQuery = true)
    List<Post> findTopByVotes(int num);
}
