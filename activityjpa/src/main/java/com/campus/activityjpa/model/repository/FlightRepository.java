
package com.campus.activityjpa.model.repository;

import com.campus.activityjpa.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    
}
