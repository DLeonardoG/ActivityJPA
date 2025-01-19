
package com.campus.activityjpa.model.repository;

import com.campus.activityjpa.model.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{
    
}
