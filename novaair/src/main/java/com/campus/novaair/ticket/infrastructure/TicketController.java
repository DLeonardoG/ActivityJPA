package com.campus.novaair.ticket.infrastructure;

import com.campus.novaair.ticket.application.TicketServiceImpl;
import com.campus.novaair.ticket.domain.Ticket;
import com.campus.novaair.ticket.domain.TicketDTO;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public TicketController(TicketServiceImpl ticketServiceImpl) {
        this.ticketServiceImpl = ticketServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<TicketDTO> getAllTickets() {
        return ticketServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> findById(@PathVariable Long id) {
        Optional<TicketDTO> ticket = ticketServiceImpl.findById(id);

        if (!ticket.isPresent()) {
            throw new TicketNotFoundException("Ticket con ID " + id + " no encontrado.");
        }

        return ResponseEntity.ok(ticket.get());
    }

    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody @Valid TicketDTO ticketDTO) {
        try {
            if (ticketDTO.getSeat() == null || ticketDTO.getSeat().isEmpty()) {
                throw new IllegalArgumentException("El campo 'seat' no puede ser nulo o vacío.");
            }

            if (ticketDTO.getFlight() == null) {
                throw new IllegalArgumentException("El campo 'flight' no puede ser nulo.");
            }

            if (ticketDTO.getPayMethod() == null || ticketDTO.getPayMethod().isEmpty()) {
                throw new IllegalArgumentException("El campo 'payMethod' no puede ser nulo o vacío.");
            }

            TicketDTO savedTicket = ticketServiceImpl.save(ticketDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al crear el ticket: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        Optional<TicketDTO> ticket = ticketServiceImpl.findById(id);

        if (!ticket.isPresent()) {
            throw new TicketNotFoundException("Ticket con ID " + id + " no encontrado.");
        }

        ticketServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable Long id, @RequestBody @Valid TicketDTO ticketDTO) {
        try {
            if (ticketDTO.getSeat() == null || ticketDTO.getSeat().isEmpty()) {
                throw new IllegalArgumentException("El campo 'seat' no puede ser nulo o vacío.");
            }

            if (ticketDTO.getFlight() == null) {
                throw new IllegalArgumentException("El campo 'flight' no puede ser nulo.");
            }

            if (ticketDTO.getPayMethod() == null || ticketDTO.getPayMethod().isEmpty()) {
                throw new IllegalArgumentException("El campo 'payMethod' no puede ser nulo o vacío.");
            }

            ticketDTO.setId(id);
            TicketDTO updatedTicket = ticketServiceImpl.save(ticketDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedTicket);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al actualizar el ticket: " + ex.getMessage());
        }
    }

}
