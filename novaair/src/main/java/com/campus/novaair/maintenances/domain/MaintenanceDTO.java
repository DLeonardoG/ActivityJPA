
package com.campus.novaair.maintenances.domain;


import com.campus.novaair.typemaintenance.domain.TypeMaintenanceDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDTO {
    private Long id;
    private LocalDate date;
    private Double costFinal;
    private String plane;
    private List<String> typesMaintenances = new ArrayList<>();

    public MaintenanceDTO() {
    }

    public MaintenanceDTO(Long id, LocalDate date, Double costFinal, String plane, List<String> typeMaintenances) {
        this.id = id;
        this.date = date;
        this.costFinal = costFinal;
        this.plane = plane;
        this.typesMaintenances = typeMaintenances;
    }
    public MaintenanceDTO( LocalDate date, Double costFinal, String plane, List<String> typeMaintenances) {
        this.date = date;
        this.costFinal = costFinal;
        this.plane = plane;
        this.typesMaintenances = typeMaintenances;
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

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public List<String> getTypesMaintenances() {
        return typesMaintenances;
    }

    public void setTypesMaintenances(List<String> typesMaintenances) {
        this.typesMaintenances = typesMaintenances;
    }
}
