package com.stosik.electric.user.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
class HttpSessionConfiguration
{
    @Bean
    public LettuceConnectionFactory connectionFactory()
    {
        return new LettuceConnectionFactory();
    }
    
}