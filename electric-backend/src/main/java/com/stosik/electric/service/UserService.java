package com.stosik.electric.service;

import com.stosik.electric.model.User;
import com.stosik.electric.model.security.UserRole;

import java.util.Optional;
import java.util.Set;

public interface UserService
{
    User createUser(User user, Set<UserRole> userRoles);
    
    User findByUsername(String username);
}
