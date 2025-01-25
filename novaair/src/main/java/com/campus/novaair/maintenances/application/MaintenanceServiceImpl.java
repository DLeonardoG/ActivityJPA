package com.campus.novaair.maintenances.application;


import com.campus.novaair.maintenances.domain.Maintenance;
import com.campus.novaair.maintenances.domain.MaintenanceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MaintenanceServicesImpl implements MaintenanceRepository{
    
    private final MaintenanceRepository maintenanceRepository;
    
    @Autowired
    public MaintenanceServicesImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }
    
    @Override
    public List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance save(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);

    }

    @Override
    public Optional findById(Long id) {
        return maintenanceRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        maintenanceRepository.deleteById(id);
    }
    
    
    
    
    
}
