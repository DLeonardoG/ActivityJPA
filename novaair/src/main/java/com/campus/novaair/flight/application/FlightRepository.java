package com.campus.novaair.flight.application;

import java.util.List;


public interface FlightRepository {
    List<Flight> findAll();
    Flight save(Flight flight);
    
}
