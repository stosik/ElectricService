package com.stosik.electric.user.domain;

import com.stosik.electric.user.domain.utility.SecurityUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    
    private final UserSecurityService userSecurityService;
    
    private BCryptPasswordEncoder passwordEncoder()
    {
        return SecurityUtility.passwordEncoder();
    }
    
    private static final String[] PUBLIC_MATCHERS = {
        "/css/**",
        "/js/**",
        "/image/**",
        "/items/**",
        "/console/**",
    };
    
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
            .csrf().disable()
            .cors().disable()
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(PUBLIC_MATCHERS)
            .permitAll()
            .anyRequest()
            .authenticated();
    
        http.headers()
            .frameOptions()
            .disable();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public HttpSessionStrategy httpSessionStrategy()
    {
        return new HeaderHttpSessionStrategy();
    }
}
