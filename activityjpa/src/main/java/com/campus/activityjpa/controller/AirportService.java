
package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.Airport;
import com.campus.activityjpa.model.repository.AirportRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    private final AirportRepository airportRepository;
    
    public AirportService (AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }
    
    public Airport saveAirport( Airport airport){
        return airportRepository.save(airport);
    }
    
    public List<Airport> getAll(){
        return airportRepository.findAll();
    }
    
    public Optional<Airport> findAirport (Long id){
        return airportRepository.findById(id);
    }
    
    public void removeAirport (Long id){
        airportRepository.deleteById(id);
    }
}
