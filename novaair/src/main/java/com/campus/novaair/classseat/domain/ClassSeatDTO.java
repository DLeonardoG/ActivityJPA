
package com.campus.novaair.classseat.domain;

public class ClassSeatDTO {
    private Long id;
    private Integer price;
    private String seatClass;

    public ClassSeatDTO() {
    }

    public ClassSeatDTO(Integer price, String seatClass) {
        this.price = price;
        this.seatClass = seatClass;
    }

    public ClassSeatDTO(Long id, Integer price, String seatClass) {
        this.id = id;
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
}
