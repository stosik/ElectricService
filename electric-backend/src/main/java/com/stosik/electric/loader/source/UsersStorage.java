package com.stosik.electric.loader.source;

import com.stosik.electric.config.security.utility.SecurityUtility;
import com.stosik.electric.model.User;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UsersStorage implements List<User>
{
    @Delegate
    List<User> users = Arrays.asList
        (
            new User("wojtek", SecurityUtility.passwordEncoder().encode("root")),
            new User("piotr", SecurityUtility.passwordEncoder().encode("root"))
        );
}
