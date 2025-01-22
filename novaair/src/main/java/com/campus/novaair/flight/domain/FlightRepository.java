package com.campus.novaair.flight.domain;

import java.util.List;


public interface FlightRepository {
    List<Flight> findAll();
    Flight save(Flight flight);
    
}
