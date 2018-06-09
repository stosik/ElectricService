package com.stosik.electric.user.domain;

import com.stosik.electric.user.domain.entity.User;
import com.stosik.electric.user.domain.entity.UserRole;

import java.util.Set;

public interface UserService
{
    User createUser(User user, Set<UserRole> userRoles);
    
    User findByUsername(String username);
}
