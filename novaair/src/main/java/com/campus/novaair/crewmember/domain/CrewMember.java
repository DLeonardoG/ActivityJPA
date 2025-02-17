
package com.campus.novaair.crewmember.domain;

import com.campus.novaair.flight.domain.Flight;
import com.campus.novaair.role.domain.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CrewMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @NotNull(message = "IDMember cannot be null")
    @Column(unique = true, length = 20)
    private String IDMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    @ManyToMany(mappedBy = "crewMembers")
    private List<Flight> flights = new ArrayList<>();

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
    
    public List<Flight> getFlights() {
        return flights;
    }
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

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
