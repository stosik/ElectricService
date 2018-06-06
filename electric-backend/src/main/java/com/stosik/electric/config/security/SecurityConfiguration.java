package com.stosik.electric.config.security;

import com.stosik.electric.config.security.utility.SecurityUtility;
import com.stosik.electric.service.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    private final Environment env;
    private final UserSecurityService userSecurityService;
    
    private static final String[] PUBLIC_MATCHERS = {
        "/css/**",
        "/js/**",
        "/image/**",
        "/item/**",
        "/user/**"
    };
    
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf()
            .disable()
            .cors()
            .disable()
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
    
    private BCryptPasswordEncoder passwordEncoder()
    {
        return SecurityUtility.passwordEncoder();
    }
}
