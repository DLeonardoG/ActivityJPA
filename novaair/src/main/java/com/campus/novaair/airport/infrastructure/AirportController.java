
package com.campus.novaair.airport.infrastructure;

import com.campus.novaair.airport.application.AirportServiceImpl;
import com.campus.novaair.airport.domain.Airport;
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
@RequestMapping("/api/airport")
public class AirportController {
    
    private final AirportServiceImpl airportServiceImpl;
    
    @Autowired
    public AirportController(AirportServiceImpl airportServiceImpl){
        this.airportServiceImpl = airportServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Airport> getAllAirport(){
        return airportServiceImpl.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional findById(@PathVariable Long id){
        return airportServiceImpl.findById(id);
    }
    
    @PostMapping
    public Airport createAirport(@RequestBody Airport airport){
        return airportServiceImpl.save(airport);
    }
    
    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id){
        airportServiceImpl.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Airport updateAirport(@PathVariable Long id, @RequestBody Airport airport){
        airport.setId(id);
        return airportServiceImpl.save(airport);
    }
    
}
