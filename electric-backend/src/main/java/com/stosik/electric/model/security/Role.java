package com.stosik.electric.model.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role implements Serializable
{
    @Id
    private Long roleId;
    
    private String name;
    
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();
}
