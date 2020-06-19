package com.robben.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.util.HashMap;

@SpringBootApplication
@EnableCaching
@MapperScan("com.robben.bbs.mapper")
//@EnableRedisHttpSession
public class BbsApplication {
    //每次请求都会经过SecurityContextPersistenceFilter
    //查看session获取过程看SessionRepositoryFilter的getRequestedSession
    //和RedisIndexedSessionRepository的loadSession
    //SessionRepositoryFilter
    //RedisIndexedSessionRepository
    /*security校验session校验是在ConcurrentSessionFilter，在doFilter方法里可以看到如果session过期*/
    public static void main(String[] args) {

        //HttpSecurity
        //SecurityContextPersistenceFilter
        //RedisIndexedSessionRepository
        SpringApplication.run(BbsApplication.class, args);
    }

}
