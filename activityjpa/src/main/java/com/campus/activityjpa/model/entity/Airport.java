
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

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    // Relación con vuelos de origen
    @OneToMany(mappedBy = "origin")
    private List<Flight> originFlights = new ArrayList<>();

    // Relación con vuelos de destino
    @OneToMany(mappedBy = "destination")
    private List<Flight> destinationFlights = new ArrayList<>();

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
    
    public List<Flight> getOriginFlights() {
        return originFlights;
    }

    public void removeFlightsOrigin(Flight originFlights) {
        this.originFlights.remove(originFlights);
        originFlights.setOrigin(null);
    }
    
    public void addFlightsOrigin(Flight originFlights) {
        this.originFlights.add(originFlights);
        originFlights.setDestination(this);
    }

    public List<Flight> getDestinationFlights() {
        return destinationFlights;
    }

    public void setDestinationFlights(Flight destinationFlights) {
        this.destinationFlights.add(destinationFlights);
        destinationFlights.setDestination(this);
    }
    
}
