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
import java.time.LocalDate;

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

    @ManyToOne
    @JoinColumn(name = "idOrigin")
    private Airport origin;

    @ManyToOne
    @JoinColumn(name = "idDestination")
    private Airport destination;

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

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", date=" + date + ", dateArrived=" + dateArrived + ", origin=" + origin + ", destination=" + destination + '}';
    }
    
    
    
}
