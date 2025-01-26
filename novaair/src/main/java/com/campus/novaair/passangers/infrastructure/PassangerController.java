package com.campus.novaair.passangers.infrastructure;


import com.campus.novaair.passangers.application.PassengerServiceImpl;
import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.passangers.domain.PassengerDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<PassengerDTO> getAllPassenger(){
        return passengerServiceImpl.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional findById(@PathVariable Long id){
        return passengerServiceImpl.findById(id);
    }
    
    
    @PostMapping
    public PassengerDTO createPassenger(@RequestBody PassengerDTO passangerDTO){
        return passengerServiceImpl.save(passangerDTO);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id){
        passengerServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public PassengerDTO updatePassenger(@PathVariable Long id, @RequestBody PassengerDTO passangerDTO){
        passangerDTO.setId(id);
        return passengerServiceImpl.save(passangerDTO);
    }
    
    
}
