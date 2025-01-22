package com.campus.novaair.flight.domain;

import java.util.List;
import java.util.Optional;


public interface FlightRepository {
    List<Flight> findAll();
    Flight save(Flight flight);
    Optional<Flight> findById(Long id);
    void deleteById(Long id);
    
}
