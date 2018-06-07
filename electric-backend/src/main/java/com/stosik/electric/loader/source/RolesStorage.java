package com.stosik.electric.loader.source;

import com.stosik.electric.model.entity.security.Role;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Set;

@Repository
public class RolesStorage implements Set<Role>
{
    @Delegate
    Set<Role> roles = Collections.singleton
        (
            new Role(2, "ROLE_USER")
        );
}
