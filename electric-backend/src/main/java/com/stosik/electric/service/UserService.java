package com.stosik.electric.service;

import com.stosik.electric.model.entity.User;
import com.stosik.electric.model.entity.security.UserRole;

import java.util.Set;

public interface UserService
{
    User createUser(User user, Set<UserRole> userRoles);
    
    User findByUsername(String username);
}
