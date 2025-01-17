
package com.campus.activityjpa.model.entity;

import jakarta.persistence.*;

@Entity
public class ClassSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer price;
    private String seatClass;
    
    public ClassSeat(Integer price, String seatClass) {
        this.price = price;
        this.seatClass = seatClass;
    }

    public ClassSeat() {
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
    
    
}