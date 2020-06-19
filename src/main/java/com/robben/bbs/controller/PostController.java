package com.robben.bbs.controller;import com.github.pagehelper.Page;import com.github.pagehelper.PageHelper;import com.robben.bbs.service.PostService;import com.robben.bbs.utilities.ResultInfo;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.*;import java.io.IOException;@RestController@RequestMapping("/post")public class PostController {    private final PostService postService;    @Autowired    public PostController(PostService postService) {        this.postService = postService;    }    @GetMapping("/topic")    public ResultInfo getTopic() {        return ResultInfo.success(postService.getTopic());    }    @GetMapping    public ResultInfo getAllPosts(@RequestParam(defaultValue = "1") Integer pageNumber,                                  @RequestParam(defaultValue = "10") Integer pageSize) {        PageHelper.startPage(pageNumber, pageSize);        return ResultInfo.success(postService.getAllPosts());    }    @GetMapping("/{id}")    public ResultInfo getPostByPostId(@PathVariable("id") Long postId) {        return ResultInfo.success(postService.getPostByPostId(postId));    }    /**     * 发布帖子     *     * @param     * @return     */    @PostMapping    public ResultInfo savePost(            @RequestParam("posterId") Long posterId,            @RequestParam("content") String content,            @RequestParam("title") String title,            @RequestParam("topic") String topic) throws IOException {        long postId = postService.savePost(posterId, content, title,                topic);        return ResultInfo.success(postId);    }    @PatchMapping    public ResultInfo updatePost(Long postId, String topic, String title, String content, Integer readingTime) {        int result = postService.updatePost(postId, topic, title, content,                readingTime);        if (result == 0) {            return ResultInfo.fail("修改失败");        }        return ResultInfo.success();    }    @DeleteMapping    public ResultInfo deletePostById(Long postId) {        int result = postService.deletePostById(postId);        if (result == 1) {            return ResultInfo.success();        }        return ResultInfo.fail("删除失败");    }}