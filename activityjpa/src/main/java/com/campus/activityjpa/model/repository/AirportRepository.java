
package com.campus.activityjpa.model.repository;

import com.campus.activityjpa.model.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository  extends JpaRepository<Airport, Long>{
    
}
