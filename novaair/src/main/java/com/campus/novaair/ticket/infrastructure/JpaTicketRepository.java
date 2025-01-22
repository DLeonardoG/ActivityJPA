/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.novaair.ticket.infrastructure;

import com.campus.novaair.ticket.domain.Ticket;
import com.campus.novaair.ticket.domain.TicketRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kevin
 */
public interface JpaTicketRepository extends JpaRepository<Ticket, Long>, TicketRepository{
    
}
