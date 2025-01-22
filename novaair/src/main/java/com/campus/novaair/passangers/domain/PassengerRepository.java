package com.campus.novaair.passangers.domain;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository {
    
    List<Passenger> findAll();
    Passenger save(Passenger passenger);
     Optional<Passenger> findById(Long id);
    void deleteById(Long id);
    
}
