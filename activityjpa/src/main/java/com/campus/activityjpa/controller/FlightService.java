
package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.Flight;
import com.campus.activityjpa.model.repository.FlightRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    
    public FlightService (FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }
    
    public Flight saveFlight( Flight flight){
        return flightRepository.save(flight);
    }
    
    public List<Flight> getAll(){
        return flightRepository.findAll();
    }
    
    public Optional<Flight> findFlight (Long id){
        return flightRepository.findById(id);
    }
    
    public void removeFlight (Long id){
        flightRepository.deleteById(id);
    }
}
