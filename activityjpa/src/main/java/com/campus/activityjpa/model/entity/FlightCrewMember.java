/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.activityjpa.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author kevin
 */
@Entity
public class FlightCrewMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCrewMember")
    private CrewMember crewMember;

    @ManyToOne
    @JoinColumn(name = "idFlight")
    private Flight flight; 

    public FlightCrewMember() {
    }
    //revisar metodo
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CrewMember getCrewMember() {
        return crewMember;
    }

    public void setCrewMember(CrewMember crewMember) {
        this.crewMember = crewMember;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "FlightCrewMember{" + "id=" + id + ", crewMember=" + crewMember + ", flight=" + flight + '}';
    }
    
    
}
