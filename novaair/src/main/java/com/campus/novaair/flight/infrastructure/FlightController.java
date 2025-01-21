
package com.campus.novaair.flight.infrastructure;

import com.campus.novaair.fligh.domain.FlightServiceImpl;
import com.campus.novaair.flight.application.Flight;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/flight")
public class FlightController {
    
    private final FlightServiceImpl flightServiceImpl;
    
    @Autowired
    public FlightController(FlightServiceImpl flightServiceImpl){
        this.flightServiceImpl = flightServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Flight> getAllFlight(){
        return flightServiceImpl.getAllFlight();
    }
    
    
}
