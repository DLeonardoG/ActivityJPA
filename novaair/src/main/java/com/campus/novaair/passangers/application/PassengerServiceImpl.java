package com.campus.novaair.passangers.application;

import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.passangers.domain.PassengerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public class PassengerServiceImpl implements PassengerRepository{
    private final PassengerRepository passengerRepository;
    
    
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }
    
    @Override
    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger save(Passenger airport) {
        return passengerRepository.save(airport);

    }

    @Override
    public Optional findById(Long id) {
        return passengerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        passengerRepository.deleteById(id);
    }
    
    
    
}
