package com.campus.novaair.airport.infrastructure;

import com.campus.novaair.airport.domain.Airport;
import com.campus.novaair.airport.domain.AirportRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAirportRepository extends JpaRepository<Airport, Long>, AirportRepository{
}
