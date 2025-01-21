
package com.campus.novaair.passangers.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String IDPassenger;
    
//    @OneToMany(mappedBy = "passenger")
//    private List<Ticket> tickets = new ArrayList<>();

    public Passenger() {
    }

    public Passenger(String IDPassenger, String name) {
        this.name = name;
        this.IDPassenger = IDPassenger;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

//    public void addTicket(Ticket ticket) {
//        this.tickets.add(ticket);
//        ticket.setPassenger(this); 
//    }
//
//    public void removeTicket(Ticket ticket) {
//        this.tickets.remove(ticket);
//        ticket.setPassenger(null);
//    }

    public String getIDPassenger() {
        return IDPassenger;
    }

    public void setIDPassenger(String IDPassenger) {
        this.IDPassenger = IDPassenger;
    }

//    public List<Ticket> getTicket() {
//        return tickets;
//    }
    
    

//    @Override
//    public String toString() {
//        return "Passenger{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
    
    
}
