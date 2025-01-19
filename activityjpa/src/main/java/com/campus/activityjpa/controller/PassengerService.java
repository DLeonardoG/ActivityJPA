
package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.Passenger;
import com.campus.activityjpa.model.repository.PassengerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;
    
    public PassengerService (PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }
    
    public Passenger savePassenger( Passenger place){
        return passengerRepository.save(place);
    }
    
    public List<Passenger> getAll(){
        return passengerRepository.findAll();
    }
    
    public Optional<Passenger> findPassenger (Long id){
        return passengerRepository.findById(id);
    }
    
    public void removePassenger (Long id){
        passengerRepository.deleteById(id);
    }
}
