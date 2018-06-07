package com.stosik.electric.repository;

import com.stosik.electric.model.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>
{
}
