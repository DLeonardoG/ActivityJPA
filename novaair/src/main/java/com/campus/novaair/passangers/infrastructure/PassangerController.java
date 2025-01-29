package com.campus.novaair.passangers.infrastructure;


import com.campus.novaair.passangers.application.PassengerServiceImpl;
import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.passangers.domain.PassengerDTO;
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
@RequestMapping("/api/passengers")
public class PassangerController {
    
    private final PassengerServiceImpl passengerServiceImpl;
    
    @Autowired
    public PassangerController(PassengerServiceImpl passengerServiceImpl){
        this.passengerServiceImpl = passengerServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PassengerDTO> getAllPassenger(){
        return passengerServiceImpl.findAll();
    }
    
    @GetMapping("/{id}")
public ResponseEntity<PassengerDTO> findById(@PathVariable String id) {
    try {
        Long passengerId = Long.parseLong(id);

        if (passengerId < 0) {
            throw new IllegalStateException("El ID no puede ser negativo");
        }

        PassengerDTO passengerDTO = passengerServiceImpl.findById(passengerId)
                .orElseThrow(() -> new PassangerNotFoundException("Passenger with ID " + passengerId + " not found"));
        return ResponseEntity.ok(passengerDTO);

    } catch (NumberFormatException ex) {
        throw new IllegalArgumentException("El ID debe ser un número válido");
    }
}

    
    
    @PostMapping
public ResponseEntity<PassengerDTO> createPassenger(@RequestBody PassengerDTO passengerDTO) {
    try {
        if (passengerDTO.getName() == null || passengerDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("El campo 'name' no puede ser nulo o vacío.");
        }
        if (passengerDTO.getIDPassenger() == null || passengerDTO.getIDPassenger().isEmpty()) {
            throw new IllegalArgumentException("El campo 'IDPassenger' no puede ser nulo o vacío.");
        }

        PassengerDTO savedPassenger = passengerServiceImpl.save(passengerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPassenger);

    } catch (IllegalArgumentException ex) {
        throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
    } catch (DataIntegrityViolationException ex) {
        throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
    } catch (Exception ex) {
        throw new IllegalStateException("Error inesperado al crear el pasajero: " + ex.getMessage());
    }
}

    
    @DeleteMapping("/{id}")
public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
    if (!passengerServiceImpl.findById(id).isPresent()) {
        throw new PassangerNotFoundException("Passenger with ID " + id + " cannot be deleted");
    }

    passengerServiceImpl.deleteById(id);
    return ResponseEntity.noContent().build();
}

    
    @PutMapping("/{id}")
public ResponseEntity<PassengerDTO> updatePassenger(@PathVariable Long id, @RequestBody PassengerDTO passengerDTO) {
    try {
        if (passengerDTO.getName() == null || passengerDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("El campo 'name' no puede ser nulo o vacío.");
        }
        if (passengerDTO.getIDPassenger() == null || passengerDTO.getIDPassenger().isEmpty()) {
            throw new IllegalArgumentException("El campo 'IDPassenger' no puede ser nulo o vacío.");
        }

        passengerDTO.setId(id);
        PassengerDTO updatedPassenger = passengerServiceImpl.save(passengerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPassenger);

    } catch (IllegalArgumentException ex) {
        throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
    } catch (DataIntegrityViolationException ex) {
        throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
    } catch (Exception ex) {
        throw new IllegalStateException("Error inesperado al actualizar el pasajero: " + ex.getMessage());
    }
}

    
    
}
