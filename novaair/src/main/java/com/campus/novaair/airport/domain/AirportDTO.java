
package com.campus.novaair.airport.domain;

public class AirportDTO {
    private Long id;
    private String name;
    private String place;

    public AirportDTO(Long id, String name, String place) {
        this.id = id;
        this.name = name;
        this.place = place;
    }

    public AirportDTO(String name, String place) {
        this.name = name;
        this.place = place;
    }

    public AirportDTO() {
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
    
}
