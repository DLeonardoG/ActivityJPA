/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.flight.application;

import com.campus.novaair.flight.domain.Flight;
import com.campus.novaair.role.domain.Role;
import java.util.List;

public interface FlightService {
   List<Flight> getAllFlight();
   Flight getFlightById(Long id);
   Flight saveFlight(Flight flight);
   void deleteFlight(Long id);
    
}
