package com.stosik.electric.service.impl;

import com.stosik.electric.model.User;
import com.stosik.electric.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService
{
    private final UserRepository userRepository;
    
    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username)
    {
        User user = userRepository.findByUsername(username);
        
        if(user == null)
        {
            log.warn("Username {} not found", username);
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        
        return user;
    }
}
