package com.campus.novaair.airport.domain;

import com.campus.novaair.airport.domain.*;
import java.util.List;
import java.util.Optional;

public interface AirportRepository {
    List<Airport> findAll();
    Airport save(Airport airport);
     Optional<Airport> findById(Long id);
    void deleteById(Long id);
}
