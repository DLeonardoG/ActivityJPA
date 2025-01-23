package com.campus.novaair.passangers.infrastructure;


import com.campus.novaair.passangers.application.PassengerServiceImpl;
import com.campus.novaair.passangers.domain.Passenger;
import java.util.List;
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
@RequestMapping("/api/passengers")
public class PassangerController {
    
    private final PassengerServiceImpl passengerServiceImpl;
    
    @Autowired
    public PassangerController(PassengerServiceImpl passengerServiceImpl){
        this.passengerServiceImpl = passengerServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Passenger> getAllRoles(){
        return passengerServiceImpl.findAll();
    }
    
    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passanger){
        return passengerServiceImpl.save(passanger);
    }
    
    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id){
        passengerServiceImpl.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passanger){
        passanger.setId(id);
        return passengerServiceImpl.save(passanger);
    }
    
    
}
