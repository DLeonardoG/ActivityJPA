
package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.Maintenance;
import com.campus.activityjpa.model.entity.TypeMaintenance;
import com.campus.activityjpa.model.repository.MaintenanceRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;
    
    public MaintenanceService (MaintenanceRepository maintenanceRepository){
        this.maintenanceRepository = maintenanceRepository;
    }
    
    public Maintenance saveMaintenance( Maintenance maintenance){
        return maintenanceRepository.save(maintenance);
    }
    
    public List<Maintenance> getAll(){
        return maintenanceRepository.findAll();
    }
    
    public Optional<Maintenance> findMaintenance (Long id){
        return maintenanceRepository.findById(id);
    }
    
    public void removeMaintenance (Long id){
        maintenanceRepository.deleteById(id);
    }
    
    @Transactional
    public Maintenance addTypeMaintenance(Maintenance maintenance, List<TypeMaintenance> typesMaintenancess){
        for (TypeMaintenance typeMaintenance : typesMaintenancess) {
            maintenance.addTypeMaintenance(typeMaintenance);
        }
        return maintenanceRepository.save(maintenance);
    }
}
