package com.robben.bbs.controller;import com.robben.bbs.service.OrdinaryUserService;import com.robben.bbs.utilities.ResultInfo;import org.springframework.data.redis.core.RedisTemplate;import org.springframework.web.bind.annotation.*;import org.springframework.web.multipart.MultipartFile;import javax.annotation.Resource;import java.io.File;import java.io.IOException;@RestController@RequestMapping("/user")public class OrdinaryUserController {    private final OrdinaryUserService ordinaryUserService;    public OrdinaryUserController(OrdinaryUserService ordinaryUserService){        this.ordinaryUserService=ordinaryUserService;    }    @Resource    private RedisTemplate<String, Object> redisTemplate;    /**     * 保存用户上传的头像     * @param multipartFile 用户上传的头像     * @param userId     * @throws IOException     */    @PostMapping("avatar")    public ResultInfo uploadUserAvatar(@RequestParam("avatar") MultipartFile multipartFile,                                       @RequestParam("userId") long userId           ) throws IOException {        String imageName=userId+multipartFile.getContentType().substring(6);        File file=new File("/Users/pengchunkao/userAvatar/"+imageName);        multipartFile.transferTo(file);        return ResultInfo.success();    }    @GetMapping("testRoot")    public  String testRoor(){        return "I need root";    }    @GetMapping("hello")    public String hello(){        redisTemplate.opsForValue().set("s","hahahaha");        Object s=redisTemplate.opsForValue().get("a");        System.out.println(s);        return "hello";    }    @GetMapping("/{userId}")    public ResultInfo getUserInfo(@PathVariable("userId") Integer userId){        return ResultInfo.success(ordinaryUserService.getUserInfoById(userId));    }}