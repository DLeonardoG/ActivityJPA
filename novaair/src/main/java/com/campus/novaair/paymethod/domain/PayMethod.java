/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.paymethod.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
@Entity
public class PayMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String payMethod;

//    @OneToMany(mappedBy = "payMethod", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Ticket> tickets = new ArrayList<>();

    public PayMethod() {
    }

    public PayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

//    public void addTicket(Ticket ticket) {
//        this.tickets.add(ticket);
//        ticket.setPayMethod(this);
//    }
//
//    public void removeTicket(Ticket ticket) {
//        this.tickets.remove(ticket);
//        ticket.setPayMethod(null);
//    }

    @Override
    public String toString() {
        return "PayMethod{" + "id=" + id + ", payMethod=" + payMethod + '}';
    }
}
