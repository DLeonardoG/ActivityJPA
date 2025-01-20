
package com.campus.activityjpa.model.repository;

import com.campus.activityjpa.model.entity.Flight;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
//    List<Flight> findByDepartureDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
