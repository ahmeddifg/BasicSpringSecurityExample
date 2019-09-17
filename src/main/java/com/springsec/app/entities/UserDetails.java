package com.springsec.app.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_name")
    private String username;
    @Column(name = "active")
    private int active;
    @Column(name = "password")
    private String password;
    @Column(name = "roles")
    private String roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         List<GrantedAuthority> authorities;
        authorities = Arrays.stream(getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        authorities.stream().forEach(e-> System.out.println(e.getAuthority()) );
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active==1?true:false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active==1?true:false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active==1?true:false;
    }

    @Override
    public boolean isEnabled() {
        return active==1?true:false;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
