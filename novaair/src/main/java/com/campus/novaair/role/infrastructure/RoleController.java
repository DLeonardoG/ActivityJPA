
package com.campus.novaair.role.infrastructure;

import com.campus.novaair.role.application.RoleServiceImpl;
import com.campus.novaair.role.domain.Role;
import com.campus.novaair.role.domain.RoleDTO;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public RoleDTO createRole(@RequestBody @Valid RoleDTO roleDTO) {
        return roleServiceImpl.save(roleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public RoleDTO updateRole(@PathVariable Long id, @RequestBody @Valid RoleDTO roleDTO) {
        roleDTO.setId(id); // Aseguramos que el ID se actualice
        return roleServiceImpl.save(roleDTO);
    }
}

