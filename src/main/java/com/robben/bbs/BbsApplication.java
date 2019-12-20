package com.robben.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableCaching
@MapperScan("com.robben.bbs.mapper")
@EnableRedisHttpSession
public class BbsApplication {
   //SecurityContextPersistenceFilter
    public static void main(String[] args) {
        //HttpSecurity
        SpringApplication.run(BbsApplication.class, args);
    }

}
