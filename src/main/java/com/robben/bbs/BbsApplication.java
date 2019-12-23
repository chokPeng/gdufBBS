package com.robben.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.SessionRepositoryFilter;

@SpringBootApplication
@EnableCaching
@MapperScan("com.robben.bbs.mapper")
@EnableRedisHttpSession
public class BbsApplication {
   //每次请求都会经过SecurityContextPersistenceFilter
    //查看session获取过程看SessionRepositoryFilter的getRequestedSession
   //和RedisIndexedSessionRepository的loadSession
    //SessionRepositoryFilter
    //RedisIndexedSessionRepository
    public static void main(String[] args) {
        //HttpSecurity
        SpringApplication.run(BbsApplication.class, args);
    }

}
