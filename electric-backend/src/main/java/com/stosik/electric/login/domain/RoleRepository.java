package com.stosik.electric.login.domain;

import com.stosik.electric.login.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>
{
}
