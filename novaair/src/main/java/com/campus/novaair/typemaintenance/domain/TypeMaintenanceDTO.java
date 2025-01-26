
package com.campus.novaair.typemaintenance.domain;

public class TypeMaintenanceDTO {
    private Long id;
    private String name;
    private Double cost;

    public TypeMaintenanceDTO() {
    }

    public TypeMaintenanceDTO(String name, Double cost) {
        this.name = name;
        this.cost = cost;
    }

    public TypeMaintenanceDTO(Long id, String name, Double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
    
    
}
