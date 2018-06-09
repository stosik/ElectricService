package com.stosik.electric.model.entity;

import com.stosik.electric.model.entity.security.Authority;
import com.stosik.electric.model.entity.security.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails, Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String password;
    private boolean enabled = true;
    
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Singular
    private Set<UserRole> userRoles = new HashSet<>();
    
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
