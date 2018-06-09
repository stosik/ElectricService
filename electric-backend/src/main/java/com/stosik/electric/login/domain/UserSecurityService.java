package com.stosik.electric.login.domain;

import com.stosik.electric.login.domain.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
class UserSecurityService implements UserDetailsService
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
