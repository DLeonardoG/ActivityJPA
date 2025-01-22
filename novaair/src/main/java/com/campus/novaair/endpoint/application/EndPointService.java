
package com.campus.novaair.endpoint.application;

import com.campus.novaair.airport.domain.Airport;
import java.util.List;

public interface EndPointService {
    List<Airport> getAllAirports();
   Airport getAirportById(Long id);
   Airport saveAirport(Airport airport);
   void deleteAirport(Long id);
}
