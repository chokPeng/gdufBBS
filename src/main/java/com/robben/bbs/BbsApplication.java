package com.robben.bbs;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.session.SessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.util.logging.Logger;

@SpringBootApplication
@EnableCaching
@MapperScan("com.robben.bbs.mapper")
@EnableRedisHttpSession
public class BbsApplication {
   //SecurityContextPersistenceFilter
    public static void main(String[] args) {

        SpringApplication.run(BbsApplication.class, args);
    }

}
