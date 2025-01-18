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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flight> flights = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idPlace")
    private Place place;

    public Airport() {
    }

    public Airport(String name) {
        this.name = name;
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
    
    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlightsDestination(Flight flight) {
        this.flights.add(flight);
        flight.setDestination(this);
    }
    
    public void addFlightsArrive(Flight flight) {
        this.flights.add(flight);
        flight.setOrigin(this);
    }
    
    public void removeFlightsDestination(Flight flight) {
        this.flights.remove(flight);
        flight.setDestination(this);
    }
    
    public void removeFlightsArrive(Flight flight) {
        this.flights.remove(flight);
        flight.setOrigin(this);
    }

    @Override
    public String toString() {
        return "Airport{" + "id=" + id + ", name=" + name + ", place=" + place + '}';
    }

    
}
