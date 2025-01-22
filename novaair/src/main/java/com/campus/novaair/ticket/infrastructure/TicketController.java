
package com.campus.novaair.ticket.infrastructure;

import com.campus.novaair.ticket.application.TicketServiceImpl;
import com.campus.novaair.ticket.domain.Ticket;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/ticket")
public class TicketController {
        private final TicketServiceImpl ticketServiceImpl;
    
    @Autowired
    public TicketController(TicketServiceImpl ticketServiceImpl){
        this.ticketServiceImpl = ticketServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Ticket> getAlltypeMaintenanceServiceImpl(){
        return ticketServiceImpl.getAllTicket();
    }
}
