
package com.campus.novaair.plane.domain;

public class PlaneDTO {
    private Long id;
    private String model;
    private Integer numSeat;

    public PlaneDTO(Long id, String model, Integer numSeat) {
        this.id = id;
        this.model = model;
        this.numSeat = numSeat;
    }

    public PlaneDTO(String model, Integer numSeat) {
        this.model = model;
        this.numSeat = numSeat;
    }

    public PlaneDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNumSeat() {
        return numSeat;
    }

    public void setNumSeat(Integer numSeat) {
        this.numSeat = numSeat;
    }
}
