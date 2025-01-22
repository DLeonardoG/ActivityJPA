/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.ticket.application;

import com.campus.novaair.ticket.domain.Ticket;
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
public class TicketServiceImpl implements TicketRepository{
    private final TicketRepository ticketRepository;
    
    public TicketServiceImpl (TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }
    
    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);

    }

    @Override
    public Optional findById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }
    
    
}
