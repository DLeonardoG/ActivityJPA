
package com.campus.novaair.ticket.infrastructure;

import com.campus.novaair.ticket.application.TicketServiceImpl;
import com.campus.novaair.ticket.domain.Ticket;
import com.campus.novaair.ticket.domain.TicketDTO;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/tickets")
public class TicketController {
        private final TicketServiceImpl ticketServiceImpl;
    
    @Autowired
    public TicketController(TicketServiceImpl ticketServiceImpl){
        this.ticketServiceImpl = ticketServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<TicketDTO> getAllTickets(){
        return ticketServiceImpl.findAll();
    }
    
     @GetMapping("/{id}")
    public Optional findById(@PathVariable Long id){
        return ticketServiceImpl.findById(id);
    }
    
    @PostMapping
    public TicketDTO createTicket(@RequestBody TicketDTO ticketDTO){
        return ticketServiceImpl.save(ticketDTO);
    }
    
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id){
        ticketServiceImpl.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public TicketDTO updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO){
        ticketDTO.setId(id);
        return ticketServiceImpl.save(ticketDTO);
    }
}
