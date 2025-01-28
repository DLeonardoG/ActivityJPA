package com.campus.novaair.ticket.application;

import com.campus.novaair.classseat.domain.ClassSeat;
import com.campus.novaair.classseat.domain.ClassSeatRepository;
import com.campus.novaair.flight.domain.Flight;
import com.campus.novaair.flight.domain.FlightRepository;
import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.passangers.domain.PassengerRepository;
import com.campus.novaair.paymethod.domain.PayMethod;
import com.campus.novaair.paymethod.domain.PayMethodRepository;
import com.campus.novaair.ticket.domain.Ticket;
import com.campus.novaair.ticket.domain.TicketDTO;
import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.ticket.domain.Ticket;
import com.campus.novaair.ticket.domain.Ticket;
import com.campus.novaair.ticket.domain.TicketDTO;
import com.campus.novaair.ticket.domain.TicketRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl {

    private final TicketRepository ticketRepository;
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ClassSeatRepository classSeatRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PayMethodRepository payMethodRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<TicketDTO> findAll() {
        return ticketRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TicketDTO save(TicketDTO ticketDTO) {
        Ticket ticket1 = convertToEntity(ticketDTO);
        Ticket savedTicket = ticketRepository.save(ticket1);
        return convertToDTO(savedTicket);
    }
 
    public Optional<TicketDTO> findById(Long id) {
        return ticketRepository.findById(id)
                .map(this::convertToDTO);
    }

    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }

    private TicketDTO convertToDTO(Ticket ticket) {
        return new TicketDTO(
                ticket.getId(),
                ticket.getDateBuy(),
                ticket.getDateFlight(),
                ticket.getSeat(),
                ticket.getFlight().getId(),
                ticket.getClassSeat().getSeatClass(),
                ticket.getPassenger().getIDPassenger(),
                ticket.getPayMethod().getName()
        );
    }

    private Ticket convertToEntity(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDTO.getId());
        ticket.setDateBuy(ticketDTO.getDateBuy());
        ticket.setDateFlight(ticketDTO.getDateFlight());
        ticket.setSeat(ticketDTO.getSeat());

        Flight flight = flightRepository.findById(ticketDTO.getFlight())
                .orElseThrow(() -> new IllegalArgumentException("ticket not found: " + ticketDTO.getFlight()));
        ticket.setFlight(flight);
        ClassSeat classSeat = classSeatRepository.findBySeatClass(ticketDTO.getClassSeat())
                .orElseThrow(() -> new IllegalArgumentException("ticket not found: " + ticketDTO.getClassSeat()));
        ticket.setClassSeat(classSeat);
        Passenger passenger = passengerRepository.findByIDPassenger(ticketDTO.getPassenger())
                .orElseThrow(() -> new IllegalArgumentException("ticket not found: " + ticketDTO.getPassenger()));
        ticket.setPassenger(passenger);
        PayMethod payMethod = payMethodRepository.findByName(ticketDTO.getPayMethod())
                .orElseThrow(() -> new IllegalArgumentException("ticket not found: " + ticketDTO.getPayMethod()));
        ticket.setPayMethod(payMethod);
        return ticket;
    }

}
