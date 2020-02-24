package com.robben.bbs.controller;import com.robben.bbs.pojo.OrdinaryUser;import com.robben.bbs.service.OrdinaryUserService;import com.robben.bbs.utilities.ResultInfo;import org.springframework.data.redis.core.RedisTemplate;import org.springframework.web.bind.annotation.*;import org.springframework.web.multipart.MultipartFile;import javax.annotation.Resource;import java.io.File;import java.io.IOException;@RestController@RequestMapping("/user")public class OrdinaryUserController {    private final OrdinaryUserService ordinaryUserService;    public OrdinaryUserController(OrdinaryUserService ordinaryUserService){        this.ordinaryUserService=ordinaryUserService;    }    @PostMapping    public ResultInfo updateUser(MultipartFile avatarFile,OrdinaryUser ordinaryUser) throws IOException {       return ResultInfo.success(ordinaryUserService.updateUser(avatarFile,ordinaryUser));    }    @GetMapping("/{userId}")    public ResultInfo getUserInfo(@PathVariable("userId") Long userId){        return ResultInfo.success(ordinaryUserService.getUserInfoById(userId));    }    @PutMapping    public ResultInfo saveUser(OrdinaryUser ordinaryUser){        return ResultInfo.success(ordinaryUserService.saveUser(ordinaryUser));    }}