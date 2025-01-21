/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.flight.infrastructure;

import com.campus.novaair.flight.application.Flight;
import com.campus.novaair.flight.application.FlightRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface JpaFlightRepository extends JpaRepository<Flight, Long>,FlightRepository{
    
}
