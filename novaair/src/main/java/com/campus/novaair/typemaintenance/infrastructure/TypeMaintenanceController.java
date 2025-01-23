
package com.campus.novaair.typemaintenance.infrastructure;

import com.campus.novaair.typemaintenance.application.TypeMaintenanceServiceImpl;
import com.campus.novaair.typemaintenance.domain.TypeMaintenance;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<TypeMaintenance> getAlltypeMaintenanceServiceImpl(){
        return typeMaintenanceServiceImpl.findAll();
    }
    
    @PostMapping
    public TypeMaintenance createTypeMaintenance(@RequestBody TypeMaintenance typeMaintenance){
        return typeMaintenanceServiceImpl.save(typeMaintenance);
    }
    
    @DeleteMapping("/{id}")
    public void deleteTypeMaintenance(@PathVariable Long id){
        typeMaintenanceServiceImpl.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public TypeMaintenance updateTypeMaintenance(@PathVariable Long id, @RequestBody TypeMaintenance typeMaintenance){
        typeMaintenance.setId(id);
        return typeMaintenanceServiceImpl.save(typeMaintenance);
    }
}
