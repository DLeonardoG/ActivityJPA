package com.campus.novaair.passangers.infrastructure;

import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.passangers.domain.PassengerRepository;
import com.campus.novaair.role.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface JpaPassengerRepository extends JpaRepository<Passenger, Long>, PassengerRepository{
    
}
