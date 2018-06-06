package com.stosik.electric.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stosik.electric.model.security.Authority;
import com.stosik.electric.model.security.UserRole;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
public class User implements UserDetails, Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false, updatable = false)
    private Long id;
    
    private String username;
    private String password;
    private boolean enabled = true;
    
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    @Singular
    private Set<UserRole> userRoles;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return userRoles
            .stream()
            .map(ur -> new Authority(ur.getRole().getName()))
            .collect(Collectors.toSet());
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
    
    public void setUsername(String username)
    {
        this.username = username;
    }
}
