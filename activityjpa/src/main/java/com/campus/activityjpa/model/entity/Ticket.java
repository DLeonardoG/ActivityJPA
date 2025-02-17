
package com.campus.activityjpa.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateBuy;
    private LocalDate dateFlight;
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

    public Ticket(LocalDate dateBuy, LocalDate dateFlight, String seat) {
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

    public LocalDate getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(LocalDate dateBuy) {
        this.dateBuy = dateBuy;
    }

    public LocalDate getDateFlight() {
        return dateFlight;
    }

    public void setDateFlight(LocalDate dateFlight) {
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
