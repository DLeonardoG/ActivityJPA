
package com.campus.activityjpa.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
        flight.setPlane(this);  // Correcto: Enlaza el vuelo con el avión.
    }

    public void removeFlight(Flight flight) {
        this.flights.remove(flight);
        flight.setPlane(null);  // Elimina la relación.
    }

    // Métodos de manejo de la relación con Maintenance
    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void addMaintenance(Maintenance maintenance) {
        this.maintenances.add(maintenance);
        maintenance.setPlane(this);  // Correcto: Enlaza el mantenimiento con el avión.
    }

    public void removeMaintenance(Maintenance maintenance) {
        this.maintenances.remove(maintenance);
        maintenance.setPlane(null);  // Elimina la relación.
    }
    
}
