/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.activityjpa.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private Integer numSeat;
    
    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flight> flights = new ArrayList<>();
    
    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Maintenance> maintenances = new ArrayList<>();

    public Plane() {
    }

    public Plane(String model, Integer numSeat) {
        this.model = model;
        this.numSeat = numSeat;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNumSeat() {
        return numSeat;
    }

    public void setNumSeat(Integer numSeat) {
        this.numSeat = numSeat;
    }
    
    public List<Flight> getFlight() {
        return flights;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
        flight.setPlane(this);
    }
    
    public void removeFlight(Flight flight) {
        this.flights.remove(flight);
        flight.setPlane(this);
    }
    
    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void addMaintenances(Maintenance maintenance) {
        this.maintenances.add(maintenance);
        maintenance.setAirplane(this);
    }
    
    
}
