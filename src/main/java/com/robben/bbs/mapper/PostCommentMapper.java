package com.robben.bbs.mapper;import com.robben.bbs.pojo.PostComment;import org.springframework.stereotype.Repository;import java.util.List;@Repositorypublic interface PostCommentMapper {    String getPostCommentPictureById(Integer id);    List<String> getPostCommentPictureByPostId(Long postId);    Integer savePostComment(String picture,Long postId,Integer commenterId,                        String content);    Integer deletePostCommentById(Integer id);    Integer deletePostCommentByPostId(Long postId);}