package com.davidandw190.apisecurity.enums;


public enum UserRole {
    ROLE_USER("123689"),
    ROLE_ADMIN("456542");

    private final String code;

    UserRole(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

