
package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.TypeMaintenance;
import com.campus.activityjpa.model.repository.TypeMaintenanceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TypeMaintenanceService {
    private final TypeMaintenanceRepository typeMaintenanceRepository;
    
    public TypeMaintenanceService (TypeMaintenanceRepository typeMaintenanceRepository){
        this.typeMaintenanceRepository = typeMaintenanceRepository;
    }
    
    public TypeMaintenance saveTypeMaintenance( TypeMaintenance typeMaintenance){
        return typeMaintenanceRepository.save(typeMaintenance);
    }
    
    public List<TypeMaintenance> getAll(){
        return typeMaintenanceRepository.findAll();
    }
    
    public Optional<TypeMaintenance> findTypeMaintenance (Long id){
        return typeMaintenanceRepository.findById(id);
    }
    
    public void removeTypeMaintenance (Long id){
        typeMaintenanceRepository.deleteById(id);
    }
}
