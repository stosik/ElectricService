package com.stosik.electric.user.domain;

import com.stosik.electric.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}
