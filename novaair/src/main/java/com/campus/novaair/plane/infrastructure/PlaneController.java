package com.campus.novaair.plane.infrastructure;

import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.application.PlaneServiceImpl;
import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.domain.PlaneDTO;
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
@RequestMapping("/api/planes")
public class PlaneController {
    
    private final PlaneServiceImpl planeServiceImpl;
    
    @Autowired
    public PlaneController(PlaneServiceImpl planeServiceImpl) {
        this.planeServiceImpl = planeServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PlaneDTO> getAllPlanes() {
        return planeServiceImpl.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PlaneDTO> findById(@PathVariable String id) {
        try {
            Long planeId = Long.parseLong(id);
            
            if (planeId < 0) {
                throw new IllegalStateException("ID no puede ser negativo");
            }
            
            PlaneDTO planeDTO = planeServiceImpl.findById(planeId)
                    .orElseThrow(() -> new PlaneNotFoundException("Plane with ID " + planeId + " not found"));
            return ResponseEntity.ok(planeDTO);
            
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El ID debe ser un número válido");
        }
    }
    
    @PostMapping
    public ResponseEntity<PlaneDTO> createPlane(@RequestBody PlaneDTO planeDTO) {
        try {
            if (planeDTO.getModel() == null || planeDTO.getModel().isEmpty()) {
                throw new IllegalArgumentException("El campo 'model' no puede ser nulo o vacío.");
            }
            if (planeDTO.getNumSeat() == null || planeDTO.getNumSeat() <= 0) {
                throw new IllegalArgumentException("El campo 'numSeat' debe ser mayor que 0.");
            }
            
            PlaneDTO savedPlane = planeServiceImpl.save(planeDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPlane);
            
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al crear el avión: " + ex.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id) {
        if (!planeServiceImpl.findById(id).isPresent()) {
            throw new PlaneNotFoundException("Plane with ID " + id + " no can delete");
        }

        planeServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PlaneDTO> updatePlane(@PathVariable Long id, @RequestBody PlaneDTO planeDTO) {
        try {
            if (planeDTO.getModel() == null || planeDTO.getModel().isEmpty()) {
                throw new IllegalArgumentException("El campo 'model' no puede ser nulo o vacío.");
            }
            if (planeDTO.getNumSeat() == null || planeDTO.getNumSeat() <= 0) {
                throw new IllegalArgumentException("El campo 'numSeat' debe ser mayor que 0.");
            }
            planeDTO.setId(id);
            
            PlaneDTO updatedPlane = planeServiceImpl.save(planeDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedPlane);
            
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al actualizar el avión: " + ex.getMessage());
        }
    }
    
}
