package com.davidandw190.apisecurity.model;

import com.davidandw190.apisecurity.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String name;
    private UserRole userRole;

    public Role() {}

    public Role(UserRole role) {
        this.userRole = role;
        this.name = role.name();
        this.code = role.getCode();
    }
}
