package com.campus.novaair.typemaintenance.infrastructure;

import com.campus.novaair.typemaintenance.application.TypeMaintenanceServiceImpl;
import com.campus.novaair.typemaintenance.domain.TypeMaintenance;
import com.campus.novaair.typemaintenance.domain.TypeMaintenanceDTO;
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
@RequestMapping("/api/typesmaintenances")
public class TypeMaintenanceController {

    private final TypeMaintenanceServiceImpl typeMaintenanceServiceImpl;

    @Autowired
    public TypeMaintenanceController(TypeMaintenanceServiceImpl typeMaintenanceServiceImpl) {
        this.typeMaintenanceServiceImpl = typeMaintenanceServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<TypeMaintenanceDTO> getAlltypeMaintenanceServiceImpl() {
        return typeMaintenanceServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeMaintenanceDTO> findById(@PathVariable Long id) {
        Optional<TypeMaintenanceDTO> typeMaintenance = typeMaintenanceServiceImpl.findById(id);

        if (!typeMaintenance.isPresent()) {
            throw new TypeMaintenanceNotFoundException("Tipo de mantenimiento con ID " + id + " no encontrado.");
        }

        return ResponseEntity.ok(typeMaintenance.get());
    }

    @PostMapping
    public ResponseEntity<TypeMaintenanceDTO> createTypeMaintenance(@RequestBody TypeMaintenanceDTO typeMaintenanceDTO) {
        try {
            if (typeMaintenanceDTO.getName() == null || typeMaintenanceDTO.getName().isEmpty()) {
                throw new IllegalArgumentException("El campo 'name' no puede ser nulo o vacío.");
            }
            if (typeMaintenanceDTO.getCost() == null || typeMaintenanceDTO.getCost() <= 0) {
                throw new IllegalArgumentException("El campo 'cost' debe ser mayor que 0.");
            }

            TypeMaintenanceDTO savedTypeMaintenance = typeMaintenanceServiceImpl.save(typeMaintenanceDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedTypeMaintenance);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al crear el tipo de mantenimiento: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeMaintenance(@PathVariable Long id) {
        if (!typeMaintenanceServiceImpl.findById(id).isPresent()) {
            throw new TypeMaintenanceNotFoundException("Type Maintenance with ID " + id + " cannot be deleted because it does not exist.");
        }

        typeMaintenanceServiceImpl.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeMaintenanceDTO> updateTypeMaintenance(@PathVariable Long id, @RequestBody TypeMaintenanceDTO typeMaintenanceDTO) {
        try {
            if (typeMaintenanceDTO.getName() == null || typeMaintenanceDTO.getName().isEmpty()) {
                throw new IllegalArgumentException("El campo 'name' no puede ser nulo o vacío.");
            }
            if (typeMaintenanceDTO.getCost() == null || typeMaintenanceDTO.getCost() <= 0) {
                throw new IllegalArgumentException("El campo 'cost' debe ser mayor que 0.");
            }

            typeMaintenanceDTO.setId(id);

            TypeMaintenanceDTO updatedTypeMaintenance = typeMaintenanceServiceImpl.save(typeMaintenanceDTO);

            return ResponseEntity.status(HttpStatus.OK).body(updatedTypeMaintenance);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al actualizar el tipo de mantenimiento: " + ex.getMessage());
        }
    }

}
