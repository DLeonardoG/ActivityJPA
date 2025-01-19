
package com.campus.activityjpa.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private Double costFinal;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "maintenceTypeMaintenance", 
        joinColumns = @JoinColumn(name = "idMaintenance"),
        inverseJoinColumns = @JoinColumn(name = "idTypeMaintenance") 
    )
    private List<TypeMaintenance> typesMaintenances = new ArrayList<>();

    
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

    public String getFormattedMaintenanceDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
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
        return typesMaintenances;
    }

    public void addTypeMaintenance(TypeMaintenance typesMaintenances) {
    if (!this.typesMaintenances.contains(typesMaintenances)) {
        this.typesMaintenances.add(typesMaintenances);
        typesMaintenances.getMaintenance().add(this);
    }
}
    
    public void removeTypeMaintenance(TypeMaintenance typesMaintenances) {
    if (this.typesMaintenances.contains(typesMaintenances)) {
        this.typesMaintenances.remove(typesMaintenances);
        typesMaintenances.getMaintenance().remove(this);
    }
}
    
}
