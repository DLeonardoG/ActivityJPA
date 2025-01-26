
package com.campus.novaair.role.domain;

import com.campus.novaair.crewmember.domain.CrewMember;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    
//    @NotNull(message = "Role name cannot be null")
    @Size(min = 3, max = 50, message = "Role name must be between 3 and 50 characters")
    private String role;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CrewMember> crewMembers = new ArrayList<>();

    public Role() {
    }

    public Role(String role) {
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
    
    public List<CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public void addCrewMembers(CrewMember crewMember) {
        this.crewMembers.add(crewMember);
        crewMember.setRole(this);
    }
    
    public void removeCrewMembers(CrewMember crewMember) {
        this.crewMembers.remove(crewMember);
        crewMember.setRole(null);
    }

//    @Override
//    public String toString() {
//        return "Role{" + "id=" + id + ", role=" + role + ", crewMembers=" + crewMembers + '}';
//    }
//    
    
}
