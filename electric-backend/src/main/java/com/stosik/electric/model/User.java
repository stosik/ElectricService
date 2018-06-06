package com.stosik.electric.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stosik.electric.model.security.Authority;
import com.stosik.electric.model.security.UserRole;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User implements UserDetails, Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false, updatable = false)
    private Long id;
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    private String email;
    private String phone;
    private boolean enabled = true;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    @Singular
    private Set<UserRole> userRoles = new HashSet<>();
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        Set<GrantedAuthority> authorities = new HashSet<>();
        userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
        return authorities;
    }
    
    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }
    
    @Override
    public boolean isEnabled()
    {
        return enabled;
    }
    
    public String getName()
    {
        return null;
    }
}
