
package com.campus.activityjpa.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class TypeMaintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double cost;
    
    @ManyToMany(mappedBy = "typesMaintenances")
    private List<Maintenance> maintenance = new ArrayList<>();

    public TypeMaintenance() {
    }

    public TypeMaintenance(String name, Double cost) {
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
    
    public List<Maintenance> getMaintenance() {
        return maintenance;
    }
    
}
