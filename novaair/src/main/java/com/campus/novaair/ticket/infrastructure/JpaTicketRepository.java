
package com.campus.novaair.ticket.infrastructure;

import com.campus.novaair.ticket.domain.Ticket;
import com.campus.novaair.ticket.domain.TicketRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTicketRepository extends JpaRepository<Ticket, Long>, TicketRepository{
    
}
