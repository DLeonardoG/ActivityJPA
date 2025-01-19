
package com.campus.activityjpa.model.repository;

import com.campus.activityjpa.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
    
}
