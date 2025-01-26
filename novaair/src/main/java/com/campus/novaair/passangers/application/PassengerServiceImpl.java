package com.campus.novaair.passangers.application;

import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.passangers.domain.PassengerDTO;
import com.campus.novaair.passangers.domain.PassengerRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;


@Service
public class PassengerServiceImpl{
    private final PassengerRepository passengerRepository;
    
    
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }
    
    
    public List<PassengerDTO> findAll() {
        return passengerRepository.findAll().stream()
              .map(this::convertToDTO)
              .collect(Collectors.toList());
    }


    public PassengerDTO save(PassengerDTO passengerDTO) {
        Passenger passenger = convertToEntity(passengerDTO);
        Passenger savedPassenger = passengerRepository.save(passenger);
        return convertToDTO(passenger);

    }

 
    public Optional<PassengerDTO> findById(Long id) {
        return passengerRepository.findById(id)
                .map(this::convertToDTO);
    }


    public void deleteById(Long id) {
        passengerRepository.deleteById(id);
    }
        private PassengerDTO convertToDTO(Passenger passenger) {
        return new PassengerDTO(passenger.getId(),
                passenger.getName(), 
                passenger.getIDPassenger());
    }

    private Passenger convertToEntity(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger(
                passengerDTO.getId(),
                passengerDTO.getName(),
                passengerDTO.getIDPassenger());
        return passenger;
    }
    
    
}
