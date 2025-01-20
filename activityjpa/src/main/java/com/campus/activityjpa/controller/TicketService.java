
package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.Ticket;
import com.campus.activityjpa.model.repository.TicketRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    
    public TicketService (TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }
    
    public Ticket saveTicket( Ticket ticket){
        return ticketRepository.save(ticket);
    }
    
    public List<Ticket> getAll(){
        return ticketRepository.findAll();
    }
    
    public Optional<Ticket> findTicket (Long id){
        return ticketRepository.findById(id);
    }
    
    public void removeTicket (Long id){
        ticketRepository.deleteById(id);
    }
    
}
