package com.stosik.electric.model.security;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Role implements Serializable
{
    @Id
    private Long roleId;
    private String name;
    
    public Role(Long roleId, String name)
    {
        this.roleId = roleId;
        this.name = name;
    }
    
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();
}
