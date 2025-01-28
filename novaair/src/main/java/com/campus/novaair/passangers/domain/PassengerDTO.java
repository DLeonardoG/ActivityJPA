package com.campus.novaair.passangers.domain;

public class PassengerDTO {

    private Long id;
    private String name;
    private String IDPassenger;

    public PassengerDTO() {
    }

    public PassengerDTO(String name, String IDPassenger) {
        this.name = name;
        this.IDPassenger = IDPassenger;
    }

    public PassengerDTO(Long id, String name, String IDPassenger) {
        this.id = id;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getIDPassenger() {
        return IDPassenger;
    }

    public void setIDPassenger(String IDPassenger) {
        this.IDPassenger = IDPassenger;
    }

}
