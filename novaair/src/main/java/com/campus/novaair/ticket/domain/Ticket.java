
package com.campus.novaair.ticket.domain;

import com.campus.novaair.classseat.domain.ClassSeat;
import com.campus.novaair.flight.domain.Flight;
import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.paymethod.domain.PayMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateBuy;
    private LocalDateTime dateFlight;
    private String seat;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFlight", nullable = false)
    private Flight flight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClassSeat", nullable = false)
    private ClassSeat classSeat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPassenger", nullable = false)
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPayMethod", nullable = false)
    private PayMethod payMethod;
    
    
    public Ticket() {
    }

    public Ticket(LocalDateTime dateBuy, LocalDateTime dateFlight, String seat) {
        this.dateBuy = dateBuy;
        this.dateFlight = dateFlight;
        this.seat = seat;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(LocalDateTime dateBuy) {
        this.dateBuy = dateBuy;
    }

    public LocalDateTime getDateFlight() {
        return dateFlight;
    }

    public void setDateFlight(LocalDateTime dateFlight) {
        this.dateFlight = dateFlight;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public ClassSeat getClassSeat() {
        return classSeat;
    }

    public void setClassSeat(ClassSeat classSeat) {
        this.classSeat = classSeat;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
    }
    
    
}
