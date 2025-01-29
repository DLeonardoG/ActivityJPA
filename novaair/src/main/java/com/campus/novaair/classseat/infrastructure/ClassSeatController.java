package com.campus.novaair.classseat.infrastructure;

import com.campus.novaair.airport.domain.Airport;
import com.campus.novaair.classseat.application.ClassSeatServiceImpl;
import com.campus.novaair.classseat.domain.ClassSeat;
import com.campus.novaair.classseat.domain.ClassSeatDTO;
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
@RequestMapping("/api/classseats")
public class ClassSeatController {

    private final ClassSeatServiceImpl classSeatServiceImpl;

    @Autowired
    public ClassSeatController(ClassSeatServiceImpl classSeatServiceImpl) {
        this.classSeatServiceImpl = classSeatServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ClassSeatDTO> getAllClassSeat() {
        return classSeatServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassSeatDTO> findById(@PathVariable String id) {
        try {
            Long classSeatId = Long.parseLong(id);

            if (classSeatId < 0) {
                throw new IllegalStateException("ID no puede ser negativo");
            }

            ClassSeatDTO classSeatDTO = classSeatServiceImpl.findById(classSeatId)
                    .orElseThrow(() -> new ClassSeatNotFoundException("Class seat with ID " + classSeatId + " not found"));
            return ResponseEntity.ok(classSeatDTO);

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El ID debe ser un número válido");
        }
    }

    @PostMapping
    public ResponseEntity<ClassSeatDTO> createClassSeat(@RequestBody ClassSeatDTO classSeatDTO) {
        try {
            if (classSeatDTO.getPrice() == null || classSeatDTO.getPrice() <= 0) {
                throw new IllegalArgumentException("El campo 'price' debe ser mayor que 0.");
            }

            if (classSeatDTO.getSeatClass() == null || classSeatDTO.getSeatClass().isEmpty()) {
                throw new IllegalArgumentException("El campo 'seatClass' no puede ser nulo o vacío.");
            }

            ClassSeatDTO savedClassSeat = classSeatServiceImpl.save(classSeatDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedClassSeat);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al crear el asiento de clase: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassSeat(@PathVariable Long id) {
        if (!classSeatServiceImpl.findById(id).isPresent()) {
            throw new ClassSeatNotFoundException("Class seat with ID " + id + " cannot be deleted because it does not exist.");
        }

        classSeatServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassSeatDTO> updateClassSeat(@PathVariable Long id, @RequestBody ClassSeatDTO classSeatDTO) {
        try {
            if (classSeatDTO.getPrice() == null || classSeatDTO.getPrice() <= 0) {
                throw new IllegalArgumentException("El campo 'price' debe ser mayor que 0.");
            }

            if (classSeatDTO.getSeatClass() == null || classSeatDTO.getSeatClass().isEmpty()) {
                throw new IllegalArgumentException("El campo 'seatClass' no puede ser nulo o vacío.");
            }

            classSeatDTO.setId(id);
            ClassSeatDTO updatedClassSeat = classSeatServiceImpl.save(classSeatDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedClassSeat);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al actualizar el asiento de clase: " + ex.getMessage());
        }
    }

}
