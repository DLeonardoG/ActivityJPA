package com.campus.novaair.passangers.application;

import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.role.domain.Role;
import java.util.List;

public interface PassengerService {
   List<Passenger> getAllPassenger();
   Passenger getPassengerById(Long id);
   Passenger savePassenger(Passenger passenger);
   void deletePassenger(Long id);
    
}
