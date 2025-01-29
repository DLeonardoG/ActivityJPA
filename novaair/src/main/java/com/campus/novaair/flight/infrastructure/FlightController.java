package com.campus.novaair.flight.infrastructure;

import com.campus.novaair.flight.application.FlightServiceImpl;
import com.campus.novaair.flight.domain.Flight;
import com.campus.novaair.flight.domain.FlightDTO;
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
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightServiceImpl flightServiceImpl;

    @Autowired
    public FlightController(FlightServiceImpl flightServiceImpl) {
        this.flightServiceImpl = flightServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<FlightDTO> getAllFlight() {
        return flightServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> findById(@PathVariable String id) {
        try {
            Long flightId = Long.parseLong(id);

            if (flightId < 0) {
                throw new IllegalStateException("ID no puede ser negativo");
            }

            FlightDTO flightDTO = flightServiceImpl.findById(flightId)
                    .orElseThrow(() -> new FlightNotFoundException("Flight with ID " + flightId + " not found"));
            return ResponseEntity.ok(flightDTO);

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El ID debe ser un número válido");
        }
    }

    @PostMapping
    public ResponseEntity<FlightDTO> createFlight(@RequestBody FlightDTO flightDTO) {
        try {
            // Validación de los campos de vuelo
            if (flightDTO.getOrigin() == null || flightDTO.getOrigin().isEmpty()) {
                throw new IllegalArgumentException("El campo 'origin' no puede ser nulo o vacío.");
            }
            if (flightDTO.getDestination() == null || flightDTO.getDestination().isEmpty()) {
                throw new IllegalArgumentException("El campo 'destination' no puede ser nulo o vacío.");
            }
            if (flightDTO.getPlane() == null || flightDTO.getPlane().isEmpty()) {
                throw new IllegalArgumentException("El campo 'plane' no puede ser nulo o vacío.");
            }

            if (flightDTO.getDate() == null) {
                throw new IllegalArgumentException("El campo 'date' no puede ser nulo.");
            }

            FlightDTO savedFlight = flightServiceImpl.save(flightDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedFlight);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al crear el vuelo: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        if (!flightServiceImpl.findById(id).isPresent()) {
            throw new FlightNotFoundException("Flight with ID " + id + " cannot be deleted because it does not exist.");
        }

        flightServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDTO> updateFlight(@PathVariable Long id, @RequestBody FlightDTO flightDTO) {
        try {
            // Validación de los campos de vuelo
            if (flightDTO.getOrigin() == null || flightDTO.getOrigin().isEmpty()) {
                throw new IllegalArgumentException("El campo 'origin' no puede ser nulo o vacío.");
            }
            if (flightDTO.getDestination() == null || flightDTO.getDestination().isEmpty()) {
                throw new IllegalArgumentException("El campo 'destination' no puede ser nulo o vacío.");
            }
            if (flightDTO.getPlane() == null || flightDTO.getPlane().isEmpty()) {
                throw new IllegalArgumentException("El campo 'plane' no puede ser nulo o vacío.");
            }

            if (flightDTO.getDate() == null) {
                throw new IllegalArgumentException("El campo 'date' no puede ser nulo.");
            }

            flightDTO.setId(id);
            FlightDTO updatedFlight = flightServiceImpl.save(flightDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedFlight);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al actualizar el vuelo: " + ex.getMessage());
        }
    }

}
