package com.campus.activityjpa.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private LocalDateTime dateArrived;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOrigin")
    private Airport origin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDestination")
    private Airport destination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPlane", nullable = false)
    private Plane plane;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "flightsCrewMembers", 
            joinColumns = @JoinColumn(name = "idFlight"), 
            inverseJoinColumns = @JoinColumn(name = "idCrewMember") 
    )
    private List<CrewMember> crewMembers = new ArrayList<>();

    public Flight() {
    }

    public Flight(LocalDateTime date, LocalDateTime dateArrived) {
        this.date = date;
        this.dateArrived = dateArrived;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(LocalDateTime dateArrived) {
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
        this.tickets.add(ticket);
        ticket.setFlight(this);
    }

    public void removeTickets(Ticket ticket) {
        this.tickets.remove(ticket);
        ticket.setFlight(this);
    }

    public void addCrewMember(CrewMember crewMember) {
        if (!this.crewMembers.contains(crewMember)) {
        this.crewMembers.add(crewMember);
        crewMember.getFlights().add(this);
    }
    }

    public void removeCrewMember(CrewMember crewMember) {
        this.crewMembers.remove(crewMember);
        crewMember.getFlights().remove(this);
    }

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + 
                ", date=" + date + ", "
                + "dateArrived=" + 
                dateArrived + '}';
    }

}
