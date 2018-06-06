package com.stosik.electric.service.impl;

import com.stosik.electric.model.User;
import com.stosik.electric.model.security.UserRole;
import com.stosik.electric.repository.RoleRepository;
import com.stosik.electric.repository.UserRepository;
import com.stosik.electric.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    
    @Transactional
    public User createUser(User user, Set<UserRole> userRoles)
    {
        User localUser = userRepository.findByUsername(user.getUsername());
        
        if(localUser != null)
        {
            log.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        }
        else
        {
            userRoles
                .forEach(ur -> roleRepository.save(ur.getRole()));

            
            user.getUserRoles().addAll(userRoles);
            
            localUser = userRepository.save(user);
        }
        
        return localUser;
    }
}
