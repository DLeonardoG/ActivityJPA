package com.campus.novaair.airport.infrastructure;

import com.campus.novaair.airport.application.AirportServiceImpl;
import com.campus.novaair.airport.domain.Airport;
import com.campus.novaair.airport.domain.AirportDTO;
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
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportServiceImpl airportServiceImpl;

    @Autowired
    public AirportController(AirportServiceImpl airportServiceImpl) {
        this.airportServiceImpl = airportServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<AirportDTO> getAllAirport() {
        return airportServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportDTO> findById(@PathVariable String id) {
        try {
            Long airportId = Long.parseLong(id);

            if (airportId < 0) {
                throw new IllegalStateException("ID no puede ser negativo");
            }

            AirportDTO airportDTO = airportServiceImpl.findById(airportId)
                    .orElseThrow(() -> new AirportNotFoundException("Airport with ID " + airportId + " not found"));
            return ResponseEntity.ok(airportDTO);

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El ID debe ser un número válido");
        }
    }

    @PostMapping
    public ResponseEntity<AirportDTO> createAirport(@RequestBody AirportDTO airportDTO) {
        try {
            // Validación de nombre
            if (airportDTO.getName() == null || airportDTO.getName().isEmpty()) {
                throw new IllegalArgumentException("El campo 'name' no puede ser nulo o vacío.");
            }

            // Validación de lugar
            if (airportDTO.getPlace() == null || airportDTO.getPlace().isEmpty()) {
                throw new IllegalArgumentException("El campo 'place' no puede ser nulo o vacío.");
            }

            // Guardar el aeropuerto
            AirportDTO savedAirport = airportServiceImpl.save(airportDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAirport);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al crear el aeropuerto: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        if (!airportServiceImpl.findById(id).isPresent()) {
            throw new AirportNotFoundException("Airport with ID " + id + " cannot be deleted because it does not exist.");
        }

        airportServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportDTO> updateAirport(@PathVariable Long id, @RequestBody AirportDTO airportDTO) {
        try {
            // Validación de nombre
            if (airportDTO.getName() == null || airportDTO.getName().isEmpty()) {
                throw new IllegalArgumentException("El campo 'name' no puede ser nulo o vacío.");
            }

            // Validación de lugar
            if (airportDTO.getPlace() == null || airportDTO.getPlace().isEmpty()) {
                throw new IllegalArgumentException("El campo 'place' no puede ser nulo o vacío.");
            }

            airportDTO.setId(id);
            AirportDTO updatedAirport = airportServiceImpl.save(airportDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedAirport);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al actualizar el aeropuerto: " + ex.getMessage());
        }
    }

}
