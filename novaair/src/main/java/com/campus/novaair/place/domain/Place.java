/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.place.domain;

import com.campus.novaair.airport.domain.Airport;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 *
 * @author kevin
 */
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String place;
    
//    @OneToOne
//    @JoinColumn(name = "id_airport")
//    private Airport airport;

    public Place() {
    }

//    public Place(String place) {
//        this.place = place;
//        this.airport = airport;
//    }
    public Place(String place) {
        this.place = place;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

//    public Airport getAirport() {
//        return airport;
//    }
//
//    public void setAirport(Airport airport) {
//        this.airport = airport;
//    }
    
    
    
    
    
    
}
