/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.novaair.ticket.application;

import com.campus.novaair.ticket.domain.Ticket;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface TicketService {
    List<Ticket> getAllTicket();

    Ticket getTicketById(Long id);

    Ticket saveTicket(Ticket ticket);

    void deleteTicket(Long id);
}
