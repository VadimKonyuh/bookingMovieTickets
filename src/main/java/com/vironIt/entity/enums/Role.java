package com.vironIt.entity.enums;

import javax.persistence.Entity;

//@Entity
public enum  Role {
    GUEST("GUEST"),
    USER("USER"),
    ADMIN("ADMIN");

    Role(String role) {
    }
}
