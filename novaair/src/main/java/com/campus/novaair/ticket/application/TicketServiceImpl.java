/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.ticket.application;

import com.campus.novaair.ticket.domain.Ticket;
import com.campus.novaair.ticket.domain.TicketRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class TicketServiceImpl {
    private final TicketRepository ticketRepository;
    
    public TicketServiceImpl (TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }
    
    public Ticket saveTicket( Ticket ticket){
        return ticketRepository.save(ticket);
    }
    
    public List<Ticket> getAllTicket(){
        return ticketRepository.findAll();
    }
    
//    public Optional<Ticket> findTicketbyId (Long id){
//        return ticketRepository.findById(id);
//    }
    
//    public void removeTicket (Long id){
//        ticketRepository.deleteById(id);
//    }
    
}
