package com.hts.market.global.config.security.auth;

import com.hts.market.domain.member.dto.MemRoleDto;
import com.hts.market.domain.member.entity.MemEntity;
import com.hts.market.domain.member.entity.MemRoleEntity;
import com.hts.market.domain.member.entity.RoleEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemDetails implements UserDetails {
    public MemEntity memEntity;
    public Collection<GrantedAuthority> roles;

    MemDetails(MemEntity memEntity, Collection<GrantedAuthority> roles) {
        this.memEntity = memEntity;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.memEntity.getMemPassword();
    }

    @Override
    public String getUsername() {
        return this.memEntity.getMemUsername();
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
        return (this.memEntity.getMemIsEnabled().equals(1)) ? true : false;
    }
}
