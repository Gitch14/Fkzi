package com.example.fkzi.model.util.enums;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    EMPTY,ROLE_STUDENT,ROLE_HEADMAN,ROLE_TEACHER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}