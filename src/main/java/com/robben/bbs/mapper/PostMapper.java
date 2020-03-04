package com.robben.bbs.mapper;import com.robben.bbs.pojo.Post;import org.springframework.stereotype.Repository;import java.util.List;@Repositorypublic interface PostMapper {    List getTopic();    List getAllPosts();    Post getPostByPostId(Long id);    Integer savePost(Long id,Long posterId,                     String content, String title, String topic);    Integer updatePost(Long postId,String topic,String title,String content,                       Integer readingTimes);    Integer deletePostById(Long id);    List getPostByTitle(String title);}