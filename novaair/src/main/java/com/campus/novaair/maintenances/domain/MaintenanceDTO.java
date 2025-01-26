
package com.campus.novaair.maintenances.domain;

import com.campus.novaair.plane.domain.PlaneDTO;
import com.campus.novaair.typemaintenance.domain.TypeMaintenanceDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDTO {
    private Long id;
    private LocalDate date;
    private Double costFinal;
    private PlaneDTO planeDTO;
    private List<TypeMaintenanceDTO> typesMaintenancesDTO = new ArrayList<>();

    public MaintenanceDTO() {
    }

    public MaintenanceDTO(Long id, LocalDate date, Double costFinal, PlaneDTO planeDTO) {
        this.id = id;
        this.date = date;
        this.costFinal = costFinal;
        this.planeDTO = planeDTO;
    }

    public MaintenanceDTO(LocalDate date, Double costFinal, PlaneDTO planeDTO) {
        this.date = date;
        this.costFinal = costFinal;
        this.planeDTO = planeDTO;
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

    public PlaneDTO getPlaneDTO() {
        return planeDTO;
    }

    public void setPlaneDTO(PlaneDTO planeDTO) {
        this.planeDTO = planeDTO;
    }

    public List<TypeMaintenanceDTO> getTypesMaintenancesDTO() {
        return typesMaintenancesDTO;
    }

    public void setTypesMaintenancesDTO(List<TypeMaintenanceDTO> typesMaintenancesDTO) {
        this.typesMaintenancesDTO = typesMaintenancesDTO;
    }
    
    
}
