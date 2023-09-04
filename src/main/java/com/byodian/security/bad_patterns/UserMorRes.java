package com.byodian.security.bad_patterns;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// The User class has two responsibilities that is a mix of two responsibilities.
// things get even more complicated
// This code isn't friendly at all
// How can we write this code to be cleaner? -> try to separate those
@Entity
public class UserMorRes implements UserDetails {
    @Id
    private Long id;
    private String username;
    private String password;
    private String authority;

    public UserMorRes(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    public UserMorRes() {
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "READ");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
