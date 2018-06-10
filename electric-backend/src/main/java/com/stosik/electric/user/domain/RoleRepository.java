package com.stosik.electric.user.domain;

import com.stosik.electric.user.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>
{
}
