package com.campus.novaair.maintenances.infrastructure;

import com.campus.novaair.maintenances.application.MaintenanceServicesImpl;
import com.campus.novaair.maintenances.domain.Maintenance;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {
    
    private final MaintenanceServicesImpl maintenanceServicesImpl;
    
    @Autowired
    public MaintenanceController(MaintenanceServicesImpl maintenanceServicesImpl){
        this.maintenanceServicesImpl = maintenanceServicesImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Maintenance> getAllMaintenance(){
        return maintenanceServicesImpl.getAllMaintenance();
    }
    
}
