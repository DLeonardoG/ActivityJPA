
package com.campus.novaair.airport.infrastructure;

import com.campus.novaair.airport.application.AirportServiceImpl;
import com.campus.novaair.airport.domain.Airport;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airport")
public class AirportController {
    
    private final AirportServiceImpl airportServiceImpl;
    
    @Autowired
    public AirportController(AirportServiceImpl airportServiceImpl){
        this.airportServiceImpl = airportServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Airport> getAllRoles(){
        return airportServiceImpl.getAllAirports();
    }
    
}
