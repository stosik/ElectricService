package com.stosik.electric.user.domain;

import com.stosik.electric.user.domain.entity.User;
import com.stosik.electric.user.domain.entity.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
class UserServiceImpl implements UserService
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
    
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }
}
