
package com.campus.novaair.crewmember.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CrewMemberDTO {
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @NotNull(message = "IDMember cannot be null")
    private String IDMember;

    private String roleName; 

    public CrewMemberDTO() {}

    public CrewMemberDTO(Long id, String name, String IDMember, String roleName) {
        this.id = id;
        this.name = name;
        this.IDMember = IDMember;
        this.roleName = roleName;
    }
    public CrewMemberDTO(String name, String IDMember, String roleName) {
        this.name = name;
        this.IDMember = IDMember;
        this.roleName = roleName;
    }
    public CrewMemberDTO(String name, String IDMember) {
        this.name = name;
        this.IDMember = IDMember;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDMember() {
        return IDMember;
    }

    public void setIDMember(String IDMember) {
        this.IDMember = IDMember;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    

}

