
package com.campus.novaair.plane.domain;

public class PlaneDTO {
    private Long id;
    private String model;
    private String name;
    private Integer numSeat;

    public PlaneDTO(Long id, String model, Integer numSeat, String name) {
        this.id = id;
        this.model = model;
        this.numSeat = numSeat;
        this.name = name;
    }

    public PlaneDTO(String model, Integer numSeat, String name) {
        this.model = model;
        this.numSeat = numSeat;
        this.name = name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
