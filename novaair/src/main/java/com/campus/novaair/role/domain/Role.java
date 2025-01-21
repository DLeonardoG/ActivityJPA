
package com.campus.novaair.role.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String role;
//    
//    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<CrewMember> crewMembers = new ArrayList<>();

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
    
//    public List<CrewMember> getCrewMembers() {
//        return crewMembers;
//    }
//
//    public void addCrewMembers(CrewMember crewMember) {
//        this.crewMembers.add(crewMember);
//        crewMember.setRole(this);
//    }
//    
//    public void removeCrewMembers(CrewMember crewMember) {
//        this.crewMembers.remove(crewMember);
//        crewMember.setRole(null);
//    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", role=" + role + ", crewMembers=" + crewMembers + '}';
    }
    
    
}
