
package com.campus.activityjpa.model.repository;

import com.campus.activityjpa.model.entity.Airport;
import com.campus.activityjpa.model.entity.CrewMember;
import com.campus.activityjpa.model.entity.Flight;
import com.campus.activityjpa.model.entity.Plane;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, Long> {
//    List<Flight> findByDepartureDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
      List<Flight> findByOriginAndDestination(Airport origin, Airport destination);
      List<Flight> findByPlane(Plane plane);
      List<Flight> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
      List<Flight> findByCrewMembers(CrewMember crewMember);
      List<Flight> findByDateBefore(LocalDateTime date);

      
    @Query("SELECT f FROM Flight f WHERE f.origin = :origin AND f.destination = :destination AND f.date > :date")
    List<Flight> findByOriginAndDestinationAfterDate(@Param("origin") Airport origin, @Param("destination") Airport destination, @Param("date") LocalDateTime date);
    @Query("SELECT f FROM Flight f WHERE SIZE(f.tickets) >= :size")
List<Flight> findByTicketsWithMinimumSize(@Param("size") int size);

}
