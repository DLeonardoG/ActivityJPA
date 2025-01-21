
package com.campus.novaair.crewmember.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CrewMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String IDMember;
//    @ManyToOne
//    @JoinColumn(name = "roleId", nullable = false)
//    private Role role;
//
//    @ManyToMany(mappedBy = "crewMembers")
//    private List<Flight> flight = new ArrayList<>();

    public CrewMember() {
    }

    public CrewMember(String IDMember, String name) {
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
    
//    public List<Flight> getFlights() {
//        return flight;
//    }
//    
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }

    public String getIDMember() {
        return IDMember;
    }

    public void setIDMember(String IDMember) {
        this.IDMember = IDMember;
    }
    
//    @Override
//    public String toString() {
//        return "CrewMember{" + "id=" + id + ", name=" + name + ", role=" + role + ", flights=" + flight + '}';
//    }
    
}
