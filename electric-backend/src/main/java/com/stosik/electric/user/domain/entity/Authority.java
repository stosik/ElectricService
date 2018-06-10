package com.stosik.electric.user.domain.entity;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@AllArgsConstructor
public class Authority implements GrantedAuthority, Serializable
{
    private final String authority;
    
    @Override
    public String getAuthority()
    {
        return authority;
    }
}