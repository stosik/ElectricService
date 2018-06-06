package com.stosik.electric.model.security;

import com.stosik.electric.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_role")
public class UserRole implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userRoleId;
    
    public UserRole(User user, Role role)
    {
        this.user = user;
        this.role = role;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
}
