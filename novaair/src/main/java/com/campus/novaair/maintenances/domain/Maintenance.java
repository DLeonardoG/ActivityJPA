
package com.campus.novaair.maintenances.domain;

import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.domain.PlaneDTO;
import com.campus.novaair.typemaintenance.domain.TypeMaintenance;
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
import jakarta.persistence.OneToOne;
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "maintenceTypeMaintenance", 
        joinColumns = @JoinColumn(name = "idMaintenance"),
        inverseJoinColumns = @JoinColumn(name = "idTypeMaintenance") 
    )
    private List<TypeMaintenance> typesMaintenances = new ArrayList<>();

    
    @OneToOne
    @JoinColumn(name = "idplane")
    private Plane plane;

    public Maintenance() {
    }

    public Maintenance(LocalDate date, Double costFinal) {
        this.date = date;
        this.costFinal = costFinal;
        
    }
    
    public Maintenance(LocalDate date, Double costFinal, Plane plane) {
        this.date = date;
        this.costFinal = costFinal;
        this.plane = plane;
    }

    public Maintenance(Long id, LocalDate date, Double costFinal, Plane plane) {
        this.id = id;
        this.date = date;
        this.costFinal = costFinal;
        this.plane = plane;
    }
    public Maintenance(Long id, LocalDate date, Double costFinal) {
        this.id = id;
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
    
    
//
//    @Override
//    public String toString() {
//        return "Maintenance{" + "id=" + id + ", date=" + date + ", costFinal=" + costFinal + ", typesMaintenances=" + typesMaintenances + ", plane=" + plane + '}';
//    }

    public List<TypeMaintenance> getTypesMaintenances() {
        return typesMaintenances;
    }

    public void setTypesMaintenances(List<TypeMaintenance> typesMaintenances) {
        this.typesMaintenances = typesMaintenances;
    }
}
