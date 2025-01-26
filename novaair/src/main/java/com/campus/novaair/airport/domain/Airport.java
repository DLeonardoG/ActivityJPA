
package com.campus.novaair.airport.domain;

import com.campus.novaair.flight.domain.Flight;
import com.campus.novaair.place.domain.Place;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "origin", fetch = FetchType.LAZY)
    private List<Flight> originFlights = new ArrayList<>();

    @OneToMany(mappedBy = "destination", fetch = FetchType.LAZY)
    private List<Flight> destinationFlights = new ArrayList<>();
    
    private String place;

    public Airport() {
    }

    public Airport(String name) {
        this.name = name;
    }

    public Airport(Long id, String name, String place) {
        this.id = id;
        this.name = name;
        this.place = place;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
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
