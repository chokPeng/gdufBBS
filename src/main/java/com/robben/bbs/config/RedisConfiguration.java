package com.robben.bbs.config;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.cache.CacheManager;import org.springframework.cache.annotation.CachingConfigurerSupport;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;import org.springframework.data.redis.cache.RedisCacheConfiguration;import org.springframework.data.redis.cache.RedisCacheManager;import org.springframework.data.redis.connection.RedisConnectionFactory;import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;import org.springframework.data.redis.core.RedisTemplate;import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;import org.springframework.data.redis.serializer.RedisSerializationContext;import org.springframework.data.redis.serializer.StringRedisSerializer;import org.springframework.session.data.redis.config.ConfigureRedisAction;import java.time.Duration;@Configurationpublic class RedisConfiguration extends CachingConfigurerSupport{    @Autowired    LettuceConnectionFactory lettuceConnectionFactory;    @Bean    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){        RedisCacheConfiguration redisCacheConfiguration=                RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(30)).disableCachingNullValues().                        serializeKeysWith(RedisSerializationContext.SerializationPair.                                fromSerializer(new StringRedisSerializer())).                        serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));        return  RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(redisCacheConfiguration).build();    }    @Bean    public RedisTemplate<Object, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {        StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();        RedisTemplate<Object, Object> template = new RedisTemplate<>();        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer =                new Jackson2JsonRedisSerializer<>(Object.class);        template.setConnectionFactory(lettuceConnectionFactory);        template.setKeySerializer(stringRedisSerializer);        template.setValueSerializer(jackson2JsonRedisSerializer);        template.setHashKeySerializer(stringRedisSerializer);        template.setHashValueSerializer(stringRedisSerializer);        template.setDefaultSerializer(jackson2JsonRedisSerializer);        return template;    }}