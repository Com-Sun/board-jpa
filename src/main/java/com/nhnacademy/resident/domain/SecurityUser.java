package com.nhnacademy.resident.domain;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails {
    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorities;

    private final String email;

    private final Long residentSerialNumber;

    public SecurityUser(String username, String password,
                        List<GrantedAuthority> authorities, String email, Long residentSerialNumber) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.email = email;
        this.residentSerialNumber = residentSerialNumber;
    }

    public String getEmail() {
        return email;
    }

    public Long getResidentSerialNumber() {
        return residentSerialNumber;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
