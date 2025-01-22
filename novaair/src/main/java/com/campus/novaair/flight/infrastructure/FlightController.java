
package com.campus.novaair.flight.infrastructure;

import com.campus.novaair.flight.application.FlightServiceImpl;
import com.campus.novaair.flight.domain.Flight;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        return flightServiceImpl.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional findById(@PathVariable Long id){
        return flightServiceImpl.findById(id);
    }
    
    @PostMapping
    public Flight createFlight(@RequestBody Flight flight){
        return flightServiceImpl.save(flight);
    }
    
    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightServiceImpl.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight){
        flight.setId(id);
        return flightServiceImpl.save(flight);
    }
    
    
    
    
}
