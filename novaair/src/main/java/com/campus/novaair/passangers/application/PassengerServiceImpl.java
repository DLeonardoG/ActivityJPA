package com.campus.novaair.passangers.application;

import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.passangers.domain.PassengerRepository;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class PassengerServiceImpl {
    private final PassengerRepository passengerRepository;
    
    
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }
    
    public List<Passenger> getAllPassenger() {
       return passengerRepository.findAll();
    }
    public Passenger saveRole(Passenger passenger) {
         return passengerRepository.save(passenger);
    }
    
}
