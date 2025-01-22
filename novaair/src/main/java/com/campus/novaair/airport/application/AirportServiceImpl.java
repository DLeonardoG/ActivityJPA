package com.campus.novaair.airport.application;

import com.campus.novaair.airport.domain.Airport;
import com.campus.novaair.airport.domain.AirportRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportRepository {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public Airport save(Airport airport) {
        return airportRepository.save(airport);

    }

    @Override
    public Optional findById(Long id) {
        return airportRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        airportRepository.deleteById(id);
    }

}
