
package com.campus.activityjpa.model.repository;

import com.campus.activityjpa.model.entity.Airport;
import com.campus.activityjpa.model.entity.Flight;
import com.campus.activityjpa.model.entity.Ticket;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
    
//    @Query("select t from Ticket t where t.idFlight = ?1")
//    Ticket getTicketByFlight(Long id);
    
    
}
