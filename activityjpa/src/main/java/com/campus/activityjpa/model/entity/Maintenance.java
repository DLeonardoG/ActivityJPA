/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.activityjpa.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

/**
 *
 * @author kevin
 */
@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private Double costFinal;

    @ManyToOne
    @JoinColumn(name = "idType")
    private TypeMaintenance type;

    @ManyToOne
    @JoinColumn(name = "idAirplane")
    private Plane airplane; 

    public Maintenance() {
    }

    public Maintenance(LocalDate date, Double costFinal) {
        this.date = date;
        this.costFinal = costFinal;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getCostFinal() {
        return costFinal;
    }

    public void setCostFinal(Double costFinal) {
        this.costFinal = costFinal;
    }

    public TypeMaintenance getType() {
        return type;
    }

    public void setType(TypeMaintenance type) {
        this.type = type;
    }

    public Plane getAirplane() {
        return airplane;
    }

    public void setAirplane(Plane airplane) {
        this.airplane = airplane;
    }

    @Override
    public String toString() {
        return "Maintenance{" + "id=" + id + ", date=" + date + ", costFinal=" + costFinal + ", type=" + type + ", airplane=" + airplane + '}';
    }
    
    
}
