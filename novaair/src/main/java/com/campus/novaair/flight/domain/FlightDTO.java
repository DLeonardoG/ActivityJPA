package com.campus.novaair.flight.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlightDTO {

    private Long id;
    private LocalDateTime date;
    private LocalDateTime dateArrived;
    private String origin;
    private String destination;
    private String plane;
    private List<String> crewMembers = new ArrayList<>();

    public FlightDTO(Long id, LocalDateTime date, LocalDateTime dateArrived, String origin, String destination, String plane) {
        this.id = id;
        this.date = date;
        this.dateArrived = dateArrived;
        this.origin = origin;
        this.destination = destination;
        this.plane = plane;
    }

    public FlightDTO(LocalDateTime date, LocalDateTime dateArrived, String origin, String destination, String plane) {
        this.date = date;
        this.dateArrived = dateArrived;
        this.origin = origin;
        this.destination = destination;
        this.plane = plane;
    }

    public FlightDTO(LocalDateTime date, LocalDateTime dateArrived, String origin, String destination, String plane, List<String> crewMembers) {
        this.date = date;
        this.dateArrived = dateArrived;
        this.origin = origin;
        this.destination = destination;
        this.plane = plane;
        this.crewMembers = crewMembers;
    }
    public FlightDTO(Long id,LocalDateTime date, LocalDateTime dateArrived, String origin, String destination, String plane, List<String> crewMembers) {
        this.id = id;
        this.date = date;
        this.dateArrived = dateArrived;
        this.origin = origin;
        this.destination = destination;
        this.plane = plane;
        this.crewMembers = crewMembers;
    }
    
    

    public FlightDTO() {
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public List<String> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(List<String> crewMembers) {
        this.crewMembers = crewMembers;
    }

}
