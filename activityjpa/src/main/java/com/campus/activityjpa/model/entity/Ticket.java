/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.activityjpa.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    
    private int codeTicket;
    
    private Date dateBuy;
    
    private double precio;
    
    private String classSeat;
    
    private boolean estate;
    
    @ManyToOne
    @JoinColumn(name = "Id_Passanger", nullable = false)
    private Passanger passanger;
    
    @ManyToOne
    @JoinColumn(name = "Id_Flight", nullable = false)
    private Flight flight;
    
    private Date dateFlight;
    
    private String seat;

    public Ticket() {
    }

    
    
    
    public Ticket(Long idTicket, int codeTicket, Date dateBuy, double precio, String classSeat, boolean estate, Date dateFlight, String seat) {
        this.idTicket = idTicket;
        this.codeTicket = codeTicket;
        this.dateBuy = dateBuy;
        this.precio = precio;
        this.classSeat = classSeat;
        this.estate = estate;
        this.dateFlight = dateFlight;
        this.seat = seat;
    }
    
    
    
    

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public int getCodeTicket() {
        return codeTicket;
    }

    public void setCodeTicket(int codeTicket) {
        this.codeTicket = codeTicket;
    }

    public Date getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getClassSeat() {
        return classSeat;
    }

    public void setClassSeat(String classSeat) {
        this.classSeat = classSeat;
    }

    public boolean isEstate() {
        return estate;
    }

    public void setEstate(boolean estate) {
        this.estate = estate;
    }
/*
    public Passanger getPassanger() {
        return passanger;
    }

    public void setPassanger(Passanger passanger) {
        this.passanger = passanger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
*/
    public Date getDateFlight() {
        return dateFlight;
    }

    public void setDateFlight(Date dateFlight) {
        this.dateFlight = dateFlight;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" + "idTicket=" + idTicket + ", codeTicket=" + codeTicket + ", dateBuy=" + dateBuy + ", precio=" + precio + ", classSeat=" + classSeat + ", estate=" + estate + ", passanger=" + passanger + ", flight=" + flight + ", dateFlight=" + dateFlight + ", seat=" + seat + '}';
    }
    
    
    
    
    
}
