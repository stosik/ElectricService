package com.stosik.electric.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

public class HttpSessionConfiguration
{
    @Bean
    public LettuceConnectionFactory connectionFactory()
    {
        return new LettuceConnectionFactory();
    }
}
