package com.campus.novaair.flight.application;

import com.campus.novaair.flight.domain.Flight;
import com.campus.novaair.flight.domain.FlightRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlightServiceImpl {
    
    private final FlightRepository flightRepository;
    
    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    
    public List<Flight> getAllFlight() {
       return flightRepository.findAll();
    }
    
    public Flight saveFlight(Flight flight) {
         return flightRepository.save(flight);
    }
    
    
}
