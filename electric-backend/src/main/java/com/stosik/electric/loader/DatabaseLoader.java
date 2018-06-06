package com.stosik.electric.loader;

import com.stosik.electric.config.security.utility.SecurityUtility;
import com.stosik.electric.loader.source.RolesStorage;
import com.stosik.electric.loader.source.UsersStorage;
import com.stosik.electric.model.User;
import com.stosik.electric.model.security.Role;
import com.stosik.electric.model.security.UserRole;
import com.stosik.electric.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DatabaseLoader
{
    private final RolesStorage roles;
    
    @Bean
    CommandLineRunner loadUsers(UserService userService, UsersStorage usersStorage)
    {
        return args -> {
            User user1 = new User();
            user1.setUsername("j");
            user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
            Set<UserRole> userRoles = new HashSet<>();
            Role role1 = new Role();
            role1.setRoleId(1);
            role1.setName("ROLE_USER");
            userRoles.add(new UserRole(user1, role1));
            
            userService.createUser(user1, userRoles);
        };
    }
}
