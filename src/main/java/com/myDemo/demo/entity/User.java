package com.myDemo.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class User implements UserDetails {
    private Integer userId;
    private String userName;
    private String password;

    public User() {
    }

    public User(int id, String userName, String password) {
        this.userId = id;
        this.userName = userName;
        this.password = password;
    }

    // Username corresponds to the email in your case
    @Override
    public String getUsername() {
        return userName;
    }

    // In a real application you should have this field
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // In a real application you should have this field
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // In a real application you should have this field
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // In a real application you should have this field
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }

    // This would normally return a collection of roles or privileges
    // that the user has, for use in authorizing their actions.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

}
