//package com.robben.bbs.controller;////import com.robben.bbs.mapper.OrdinaryUserMapper;//import com.robben.bbs.service.PostCommentService;//import com.robben.bbs.service.RedisService;//import com.robben.bbs.utilities.ResultInfo;//import org.springframework.beans.factory.annotation.Autowired;//import org.springframework.data.redis.core.RedisTemplate;//import org.springframework.web.bind.annotation.GetMapping;//import org.springframework.web.bind.annotation.PostMapping;//import org.springframework.web.bind.annotation.RestController;////import java.util.concurrent.TimeUnit;////@RestController//public class TestController {//    RedisTemplate<String,Object> redisTemplate;//    private RedisService redisService;//    @Autowired//    public TestController(RedisTemplate redisTemplate,RedisService redisService){//        this.redisTemplate=redisTemplate;//        this.redisService=redisService;//    }//    @PostMapping("/test")//    public ResultInfo test(Integer userNo){////        redisTemplate.opsForHash().put("caidapao",key,value);////        redisTemplate.opsForHash().put("caidapao","sex","男");////        System.out.println(redisTemplate.getExpire("caidapao"));////       redisTemplate.expire("caidapao",60,TimeUnit.SECONDS);////        System.out.println(redisTemplate.getExpire("caidapao"));//  //      return ResultInfo.success(redisTemplate.opsForHash().entries("caidapao"));//        return  ResultInfo.success(redisService.saveOnlineUser(userNo));//    }//}