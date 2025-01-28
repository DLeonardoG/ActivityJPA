
package com.campus.novaair.ticket.domain;

import java.time.LocalDateTime;

public class TicketDTO {
    private Long id;
    private LocalDateTime dateBuy;
    private LocalDateTime dateFlight;
    private String seat;
    
    private Long flight;
    private String classSeat;
    private String passenger;
    private String payMethod;

    public TicketDTO() {
    }

    public TicketDTO(LocalDateTime dateBuy, LocalDateTime dateFlight, String seat, Long flight, String classSeat, String passenger, String payMethod) {
        this.dateBuy = dateBuy;
        this.dateFlight = dateFlight;
        this.seat = seat;
        this.flight = flight;
        this.classSeat = classSeat;
        this.passenger = passenger;
        this.payMethod = payMethod;
    }

    public TicketDTO(Long id, LocalDateTime dateBuy, LocalDateTime dateFlight, String seat, Long flight, String classSeat, String passenger, String payMethod) {
        this.id = id;
        this.dateBuy = dateBuy;
        this.dateFlight = dateFlight;
        this.seat = seat;
        this.flight = flight;
        this.classSeat = classSeat;
        this.passenger = passenger;
        this.payMethod = payMethod;
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

    public Long getFlight() {
        return flight;
    }

    public void setFlight(Long flight) {
        this.flight = flight;
    }

    public String getClassSeat() {
        return classSeat;
    }

    public void setClassSeat(String classSeat) {
        this.classSeat = classSeat;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "TicketDTO{" + "id=" + id + ", dateBuy=" + dateBuy + ", dateFlight=" + dateFlight + ", seat=" + seat + ", flight=" + flight + ", classSeat=" + classSeat + ", passenger=" + passenger + ", payMethod=" + payMethod + '}';
    }
    
    
    
    
    
}
