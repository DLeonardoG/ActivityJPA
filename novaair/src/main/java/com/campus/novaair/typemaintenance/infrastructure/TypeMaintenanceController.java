
package com.campus.novaair.typemaintenance.infrastructure;

import com.campus.novaair.typemaintenance.application.TypeMaintenanceServiceImpl;
import com.campus.novaair.typemaintenance.domain.TypeMaintenance;
import com.campus.novaair.typemaintenance.domain.TypeMaintenanceDTO;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/typesmaintenances")
public class TypeMaintenanceController {
    private final TypeMaintenanceServiceImpl typeMaintenanceServiceImpl;
    
    @Autowired
    public TypeMaintenanceController(TypeMaintenanceServiceImpl typeMaintenanceServiceImpl){
        this.typeMaintenanceServiceImpl = typeMaintenanceServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<TypeMaintenanceDTO> getAlltypeMaintenanceServiceImpl(){
        return typeMaintenanceServiceImpl.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional findById(@PathVariable Long id){
        return typeMaintenanceServiceImpl.findById(id);
    }
    
    @PostMapping
    public TypeMaintenanceDTO createTypeMaintenance(@RequestBody TypeMaintenanceDTO typeMaintenanceDTO){
        return typeMaintenanceServiceImpl.save(typeMaintenanceDTO);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeMaintenance(@PathVariable Long id){
        typeMaintenanceServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public TypeMaintenanceDTO updateTypeMaintenance(@PathVariable Long id, @RequestBody TypeMaintenanceDTO typeMaintenanceDTO){
        typeMaintenanceDTO.setId(id);
        return typeMaintenanceServiceImpl.save(typeMaintenanceDTO);
    }
}
