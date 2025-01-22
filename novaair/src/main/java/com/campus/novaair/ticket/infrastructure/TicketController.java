
package com.campus.novaair.ticket.infrastructure;

import com.campus.novaair.ticket.application.TicketServiceImpl;
import com.campus.novaair.ticket.domain.Ticket;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        return ticketServiceImpl.findAll();
    }
    
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketServiceImpl.save(ticket);
    }
    
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id){
        ticketServiceImpl.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticket){
        ticket.setId(id);
        return ticketServiceImpl.save(ticket);
    }
}
