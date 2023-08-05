package com.davidandw190.apisecurity.model;

import com.davidandw190.apisecurity.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String name; // Update to String type
    private UserRole userRole; // Add UserRole enum field

    public Role(UserRole role) {
        this.userRole = role;
        this.name = role.name(); // Set the name as the enum's name
        this.code = role.getCode();
    }
}
