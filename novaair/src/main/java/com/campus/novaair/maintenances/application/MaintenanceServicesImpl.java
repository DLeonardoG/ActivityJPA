package com.campus.novaair.maintenances.application;

import com.campus.novaair.maintenances.domain.Maintenance;
import com.campus.novaair.maintenances.domain.MaintenanceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MaintenanceServicesImpl {
    
    private final MaintenanceRepository maintenanceRepository;
    
    @Autowired
    public MaintenanceServicesImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }
    
    public List<Maintenance> getAllMaintenance() {
       return maintenanceRepository.findAll();
    }
    
    public Maintenance saveMaintenance(Maintenance maintenance) {
         return maintenanceRepository.save(maintenance);
    }
    
    
    
}
