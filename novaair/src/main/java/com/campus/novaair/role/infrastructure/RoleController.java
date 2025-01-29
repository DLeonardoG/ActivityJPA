package com.campus.novaair.role.infrastructure;

import com.campus.novaair.role.application.RoleServiceImpl;
import com.campus.novaair.role.domain.Role;
import com.campus.novaair.role.domain.RoleDTO;
import jakarta.validation.Valid;
import java.util.List;
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
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleServiceImpl roleServiceImpl;

    @Autowired
    public RoleController(RoleServiceImpl roleServiceImpl) {
        this.roleServiceImpl = roleServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RoleDTO> getAllRoles() {
        return roleServiceImpl.findAll();
    }

    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@RequestBody @Valid RoleDTO roleDTO) {
        try {
            if (roleDTO.getRole() == null || roleDTO.getRole().isEmpty()) {
                throw new IllegalArgumentException("El campo 'role' no puede ser nulo o vacío.");
            }

            RoleDTO savedRole = roleServiceImpl.save(roleDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al crear el rol: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        if (!roleServiceImpl.findById(id).isPresent()) {
            throw new RoleNotFoundException("Role with ID " + id + " cannot be deleted");
        }

        roleServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable Long id, @RequestBody @Valid RoleDTO roleDTO) {
        try {
            if (roleDTO.getRole() == null || roleDTO.getRole().isEmpty()) {
                throw new IllegalArgumentException("El campo 'role' no puede ser nulo o vacío.");
            }

            roleDTO.setId(id);
            RoleDTO updatedRole = roleServiceImpl.save(roleDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedRole);

        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error de validación: " + ex.getMessage());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Violación de integridad de datos: " + ex.getMessage());
        } catch (Exception ex) {
            throw new IllegalStateException("Error inesperado al actualizar el rol: " + ex.getMessage());
        }
    }

}
