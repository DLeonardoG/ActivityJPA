package com.campus.novaair.crewmember.infraestructure;

import com.campus.novaair.crewmember.application.CrewMemberServiceImpl;
import com.campus.novaair.crewmember.domain.CrewMember;
import com.campus.novaair.crewmember.domain.CrewMemberDTO;
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
@RequestMapping("/api/crewmembers")
public class CrewMemberController {

    private final CrewMemberServiceImpl crewMemberServiceImpl;

    @Autowired
    public CrewMemberController(CrewMemberServiceImpl crewMemberServiceImpl) {
        this.crewMemberServiceImpl = crewMemberServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CrewMemberDTO> getAllCrewMembers() {
        return crewMemberServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrewMemberDTO> findById(@PathVariable String id) {
        try {
            Long crewMemberId = Long.parseLong(id);

            if (crewMemberId < 0) {
                throw new IllegalStateException("ID no puede ser negativo");
            }

            CrewMemberDTO crewMemberDTO = crewMemberServiceImpl.findById(crewMemberId)
                    .orElseThrow(() -> new CrewmembertNotFoundException("Crew member with ID " + crewMemberId + " not found"));
            return ResponseEntity.ok(crewMemberDTO);

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El ID debe ser un número válido");
        }
    }

    @PostMapping
    public ResponseEntity<CrewMemberDTO> createCrewMember(@RequestBody CrewMemberDTO crewMemberDTO) {
        try {
            // Validación del nombre
            if (crewMemberDTO.getName() == null || crewMemberDTO.getName().isEmpty()) {
                throw new IllegalArgumentException("El campo 'name' no puede ser nulo o vacío.");
            }
            if (crewMemberDTO.getName().length() < 3 || crewMemberDTO.getName().length() > 100) {
                throw new IllegalArgumentException("El campo 'name' debe tener entre 3 y 100 caracteres.");
            }

            // Validación del ID de miembro
            if (crewMemberDTO.getIDMember() == null || crewMemberDTO.getIDMember().isEmpty()) {
                throw new IllegalArgumentException("El campo 'IDMember' no puede ser nulo o vacío.");
            }

            CrewMemberDTO savedCrewMember = crewMemberServiceImpl.save(crewMemberDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCrewMember);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al crear el miembro de la tripulación: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrewMember(@PathVariable Long id) {
        if (!crewMemberServiceImpl.findById(id).isPresent()) {
            throw new CrewmembertNotFoundException("Crew member with ID " + id + " cannot be deleted because it does not exist.");
        }

        crewMemberServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CrewMemberDTO> updateCrewMember(@PathVariable Long id, @RequestBody CrewMemberDTO crewMemberDTO) {
        try {
            // Validación del nombre
            if (crewMemberDTO.getName() == null || crewMemberDTO.getName().isEmpty()) {
                throw new IllegalArgumentException("El campo 'name' no puede ser nulo o vacío.");
            }
            if (crewMemberDTO.getName().length() < 3 || crewMemberDTO.getName().length() > 100) {
                throw new IllegalArgumentException("El campo 'name' debe tener entre 3 y 100 caracteres.");
            }

            // Validación del ID de miembro
            if (crewMemberDTO.getIDMember() == null || crewMemberDTO.getIDMember().isEmpty()) {
                throw new IllegalArgumentException("El campo 'IDMember' no puede ser nulo o vacío.");
            }

            crewMemberDTO.setId(id);
            CrewMemberDTO updatedCrewMember = crewMemberServiceImpl.save(crewMemberDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedCrewMember);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al actualizar el miembro de la tripulación: " + ex.getMessage());
        }
    }

}
