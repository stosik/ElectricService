package com.stosik.electric.login.domain;

import com.stosik.electric.login.domain.entity.User;
import com.stosik.electric.login.domain.entity.UserRole;

import java.util.Set;

public interface UserService
{
    User createUser(User user, Set<UserRole> userRoles);
    
    User findByUsername(String username);
}
