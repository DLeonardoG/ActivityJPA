package com.campus.novaair.passangers.infrastructure;

import com.campus.novaair.passangers.application.PassengerServiceImpl;
import com.campus.novaair.passangers.domain.Passenger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/passenger")
public class PassangerController {
    
    private final PassengerServiceImpl passengerServiceImpl;
    
    @Autowired
    public PassangerController(PassengerServiceImpl passengerServiceImpl){
        this.passengerServiceImpl = passengerServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Passenger> getAllRoles(){
        return passengerServiceImpl.getAllPassenger();
    }
    
    
}
