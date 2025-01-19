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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
        name = "maintenceTypeMaintenance", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "idMaintenance"), // Columna que une con Flight
        inverseJoinColumns = @JoinColumn(name = "idTypeMaintenance") // Columna que une con CrewMember
    )
    private List<TypeMaintenance> typeMaintenance = new ArrayList<>();

    
    @ManyToOne
    @JoinColumn(name = "idplane")
    private Plane plane;

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

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
    
    public List<TypeMaintenance> getTypeMaintenance() {
        return typeMaintenance;
    }

    public void addTypeMaintenance(TypeMaintenance typeMaintenance) {
    if (!this.typeMaintenance.contains(typeMaintenance)) {
        this.typeMaintenance.add(typeMaintenance);
        typeMaintenance.getMaintenance().add(this);
    }
}
    
    public void removeTypeMaintenance(TypeMaintenance typeMaintenance) {
    if (this.typeMaintenance.contains(typeMaintenance)) {
        this.typeMaintenance.remove(typeMaintenance);
        typeMaintenance.getMaintenance().remove(this);
    }
}
    
}
