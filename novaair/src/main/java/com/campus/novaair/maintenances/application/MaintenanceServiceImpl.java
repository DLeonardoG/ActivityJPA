package com.campus.novaair.maintenances.application;


import com.campus.novaair.maintenances.domain.Maintenance;
import com.campus.novaair.maintenances.domain.MaintenanceRepository;
import com.campus.novaair.typemaintenance.domain.TypeMaintenance;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MaintenanceServiceImpl {
    
    private final MaintenanceRepository maintenanceRepository;
    
    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }
    
    public List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }
    
    public Maintenance save(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);

    }
    
    public Optional findById(Long id) {
        return maintenanceRepository.findById(id);
    }
    
    public void deleteById(Long id) {
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
