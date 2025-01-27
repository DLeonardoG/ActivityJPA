
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
    private List<TypeMaintenanceDTO> typesMaintenancesDTO = new ArrayList<>();

    public MaintenanceDTO() {
    }

    public MaintenanceDTO(Long id, LocalDate date, Double costFinal, String plane) {
        this.id = id;
        this.date = date;
        this.costFinal = costFinal;
        this.plane = plane;
    }

    public MaintenanceDTO(LocalDate date, Double costFinal, String plane) {
        this.date = date;
        this.costFinal = costFinal;
        this.plane = plane;
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

    public List<TypeMaintenanceDTO> getTypesMaintenancesDTO() {
        return typesMaintenancesDTO;
    }

    public void setTypesMaintenancesDTO(List<TypeMaintenanceDTO> typesMaintenancesDTO) {
        this.typesMaintenancesDTO = typesMaintenancesDTO;
    }
}
