package com.example.demo.entities;

import java.util.Set;

public enum RoleEnum {
    USER,
    ADMIN,
    MODERATOR;

    public static boolean validate(Set<String> roles) {
        for (String role : roles) {
            try {
                RoleEnum.valueOf(role);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return true;
    }
}
