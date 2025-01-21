package com.campus.novaair.airport.domain;

import com.campus.novaair.airport.domain.Airport;
import java.util.List;

public interface AirportRepository {
    List<Airport> findAll();
    Airport save(Airport airport);
    
}
