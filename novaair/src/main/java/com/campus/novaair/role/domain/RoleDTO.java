
package com.campus.novaair.role.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RoleDTO {
    private Long id;

//    @NotNull(message = "Role name cannot be null")
    @Size(min = 3, max = 50, message = "Role name must be between 3 and 50 characters")
    private String role;

    public RoleDTO() {}

    public RoleDTO(Long id, String role) {
        this.id = id;
        this.role = role;
    }
    public RoleDTO(String role) {
        this.role = role;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
