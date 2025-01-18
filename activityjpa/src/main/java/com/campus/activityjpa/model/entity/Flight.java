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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private LocalDate dateArrived;
    
    @OneToMany(mappedBy = "Flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

    
    
    @ManyToOne
    @JoinColumn(name = "idOrigin")
    private Airport origin;

    @ManyToOne
    @JoinColumn(name = "idDestination")
    private Airport destination;
    
    @ManyToOne
    @JoinColumn(name = "idPlane")
    private Plane plane;

    @ManyToMany
    @JoinTable(
        name = "flightsCrewMembers", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "idFlight"), // Columna que une con Flight
        inverseJoinColumns = @JoinColumn(name = "idCrewMember") // Columna que une con CrewMember
    )
    private List<CrewMember> crewMembers = new ArrayList<>();
    
    
    
    public Flight() {
    }

    public Flight(LocalDate date, LocalDate dateArrived) {
        this.date = date;
        this.dateArrived = dateArrived;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(LocalDate dateArrived) {
        this.dateArrived = dateArrived;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }
    
    public List<CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public void addCrewMember(CrewMember crewMember) {
        this.crewMembers.add(crewMember);
        crewMember.getFlights().add(this); // Asegurar consistencia en ambos lados
    }
    
    public void removeCrewMember(CrewMember crewMember) {
        this.crewMembers.remove(crewMember);
        crewMember.getFlights().remove(this); // Asegurar consistencia en ambos lados
    }
    
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
    
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTickets(Ticket ticket) {
        this.tickets .add(ticket);
        ticket.setFlight(this);
    }
    
    public void removeTickets(Ticket ticket) {
        this.tickets .remove(ticket);
        ticket.setFlight(this);
    }
    
    
    
}
