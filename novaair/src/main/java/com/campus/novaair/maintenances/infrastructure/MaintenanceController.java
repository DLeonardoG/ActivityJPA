package com.campus.novaair.maintenances.infrastructure;

import com.campus.novaair.maintenances.application.MaintenanceServiceImpl;
import com.campus.novaair.maintenances.domain.Maintenance;
import com.campus.novaair.maintenances.domain.MaintenanceDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {

    private final MaintenanceServiceImpl maintenanceServicesImpl;

    @Autowired
    public MaintenanceController(MaintenanceServiceImpl maintenanceServicesImpl) {
        this.maintenanceServicesImpl = maintenanceServicesImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<MaintenanceDTO> getAllMaintenance() {
        return maintenanceServicesImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceDTO> findById(@PathVariable String id) {
        try {
            Long maintenanceId = Long.parseLong(id);

            if (maintenanceId < 0) {
                throw new IllegalStateException("ID no puede ser negativo");
            }

            MaintenanceDTO maintenanceDTO = maintenanceServicesImpl.findById(maintenanceId)
                    .orElseThrow(() -> new MaintenanceFlightNotFoundException("Maintenance with ID " + maintenanceId + " not found"));
            return ResponseEntity.ok(maintenanceDTO);

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El ID debe ser un número válido");
        }
    }

    @PostMapping
    public ResponseEntity<MaintenanceDTO> createMaintenance(@RequestBody MaintenanceDTO maintenanceDTO) {
        try {
            // Validación de los campos de mantenimiento
            if (maintenanceDTO.getPlane() == null || maintenanceDTO.getPlane().isEmpty()) {
                throw new IllegalArgumentException("El campo 'plane' no puede ser nulo o vacío.");
            }
            if (maintenanceDTO.getCostFinal() == null || maintenanceDTO.getCostFinal() <= 0) {
                throw new IllegalArgumentException("El campo 'costFinal' debe ser mayor que 0.");
            }
            if (maintenanceDTO.getDate() == null) {
                throw new IllegalArgumentException("El campo 'date' no puede ser nulo.");
            }
            if (maintenanceDTO.getTypesMaintenances() == null || maintenanceDTO.getTypesMaintenances().isEmpty()) {
                throw new IllegalArgumentException("El campo 'typesMaintenances' no puede estar vacío.");
            }

            MaintenanceDTO savedMaintenance = maintenanceServicesImpl.save(maintenanceDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMaintenance);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al crear el mantenimiento: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable Long id) {
        if (!maintenanceServicesImpl.findById(id).isPresent()) {
            throw new MaintenanceFlightNotFoundException("Maintenance with ID " + id + " cannot be deleted because it does not exist.");
        }

        maintenanceServicesImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaintenanceDTO> updateMaintenance(@PathVariable Long id, @RequestBody MaintenanceDTO maintenanceDTO) {
        try {
            // Validación de los campos de mantenimiento
            if (maintenanceDTO.getPlane() == null || maintenanceDTO.getPlane().isEmpty()) {
                throw new IllegalArgumentException("El campo 'plane' no puede ser nulo o vacío.");
            }
            if (maintenanceDTO.getCostFinal() == null || maintenanceDTO.getCostFinal() <= 0) {
                throw new IllegalArgumentException("El campo 'costFinal' debe ser mayor que 0.");
            }
            if (maintenanceDTO.getDate() == null) {
                throw new IllegalArgumentException("El campo 'date' no puede ser nulo.");
            }
            if (maintenanceDTO.getTypesMaintenances() == null || maintenanceDTO.getTypesMaintenances().isEmpty()) {
                throw new IllegalArgumentException("El campo 'typesMaintenances' no puede estar vacío.");
            }

            maintenanceDTO.setId(id);
            MaintenanceDTO updatedMaintenance = maintenanceServicesImpl.save(maintenanceDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedMaintenance);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al actualizar el mantenimiento: " + ex.getMessage());
        }
    }

}
