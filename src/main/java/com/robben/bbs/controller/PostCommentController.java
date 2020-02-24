package com.robben.bbs.controller;import com.robben.bbs.service.PostCommentService;import com.robben.bbs.utilities.ResultInfo;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.*;import org.springframework.web.multipart.MultipartFile;import java.io.IOException;@RestController@RequestMapping("/postComment")public class PostCommentController {    private final PostCommentService postCommentService;    @Autowired    public PostCommentController(PostCommentService postCommentService){        this.postCommentService=postCommentService;    }    /**     * 发表评论     * @param     * @return     */    @PostMapping    public ResultInfo saveComment(Long postId,Long commenterId,                                  String content) throws IOException {        int res=postCommentService.savePostComment(postId,                commenterId,content);        if(res==1) {            return ResultInfo.success();        }        return ResultInfo.fail("保存失败");    }    /**     * 删除评论     * @param id     * @return     */    @DeleteMapping    public ResultInfo deletePostCommentById(Integer id){        int res=postCommentService.deletePostCommentById(id);        if(res!=0) {            return ResultInfo.success();        }        return ResultInfo.fail("删除失败");    }}