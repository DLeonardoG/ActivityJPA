/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.airport.application;

import com.campus.novaair.airport.domain.Airport;
import java.util.List;

public interface AirportService {
    List<Airport> getAllAirports();
   Airport getAirportById(Long id);
   Airport saveAirport(Airport airport);
   void deleteAirport(Long id);
}
