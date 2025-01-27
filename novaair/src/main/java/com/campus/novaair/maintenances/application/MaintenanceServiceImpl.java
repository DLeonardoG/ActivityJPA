package com.campus.novaair.maintenances.application;


import com.campus.novaair.maintenances.domain.Maintenance;
import com.campus.novaair.maintenances.domain.MaintenanceDTO;
import com.campus.novaair.maintenances.domain.MaintenanceRepository;
import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.domain.PlaneRepository;
import com.campus.novaair.typemaintenance.domain.TypeMaintenance;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceServiceImpl {

    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public List<MaintenanceDTO> findAll() {
        return maintenanceRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MaintenanceDTO save(MaintenanceDTO maintenanceDTO) {
        Maintenance maintenance = convertToEntity(maintenanceDTO);
        Maintenance savedMaintenance = maintenanceRepository.save(maintenance);
        return convertToDTO(maintenance);

    }

    public Optional<MaintenanceDTO> findById(Long id) {
        return maintenanceRepository.findById(id)
                .map(this::convertToDTO);
    }

    public void deleteById(Long id) {
        maintenanceRepository.deleteById(id);
    }

    @Transactional
    public Maintenance addTypeMaintenance(Maintenance maintenance, List<TypeMaintenance> typesMaintenancess) {
        for (TypeMaintenance typeMaintenance : typesMaintenancess) {
            maintenance.addTypeMaintenance(typeMaintenance);
        }
        return maintenanceRepository.save(maintenance);
    }

    private MaintenanceDTO convertToDTO(Maintenance maintenance) {
        return new MaintenanceDTO(
                maintenance.getId(),
                maintenance.getDate(),
                maintenance.getCostFinal(),
                maintenance.getPlane().getName()
        );
    }
    private Maintenance convertToEntity(MaintenanceDTO maintenanceDTO) {
        Maintenance maintenance = new Maintenance(
                maintenanceDTO.getId(),
                maintenanceDTO.getDate(),
                maintenanceDTO.getCostFinal()
        );
        Plane plane = planeRepository.findByName(maintenanceDTO.getPlane())
                .orElseThrow(() -> new IllegalArgumentException("Plane not found: " + maintenanceDTO.getPlane()));
        maintenance.setPlane(plane);

        return maintenance;
    }

}
