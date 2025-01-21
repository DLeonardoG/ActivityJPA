/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.airport.application;

import com.campus.novaair.airport.domain.Airport;
import com.campus.novaair.airport.domain.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl {
    
    private final AirportRepository airportRepository;
    
    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }
    
    public List<Airport> getAllAirports() {
       return airportRepository.findAll();
    }
    
    public Airport saveAirport(Airport airport) {
         return airportRepository.save(airport);
    }
    
    
}
