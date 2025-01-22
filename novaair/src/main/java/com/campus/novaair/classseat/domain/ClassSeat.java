
package com.campus.novaair.classseat.domain;

import com.campus.novaair.ticket.domain.Ticket;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ClassSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer price;
    private String seatClass;
    
    @OneToMany(mappedBy = "classSeat", orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

    public ClassSeat() {
    }

    public ClassSeat(Integer price, String seatClass) {
        this.price = price;
        this.seatClass = seatClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }
    
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
        ticket.setClassSeat(this);
    }

    public void removeTicket(Ticket ticket) {
        this.tickets.remove(ticket);
        ticket.setClassSeat(null);
    }

//    @Override
//    public String toString() {
//        return "ClassSeat{" +
//                "id=" + id +
//                ", price=" + price +
//                ", seatClass='" + seatClass + '\'' +
//                '}';
//    }
    
    
}
