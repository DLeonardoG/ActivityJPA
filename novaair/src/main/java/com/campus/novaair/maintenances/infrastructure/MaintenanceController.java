package com.campus.novaair.maintenances.infrastructure;


import com.campus.novaair.maintenances.application.MaintenanceServiceImpl;
import com.campus.novaair.maintenances.domain.Maintenance;
import com.campus.novaair.maintenances.domain.MaintenanceDTO;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/maintenances")
public class MaintenanceController {
    
    private final MaintenanceServiceImpl maintenanceServicesImpl;
    
    @Autowired
    public MaintenanceController(MaintenanceServiceImpl maintenanceServicesImpl){
        this.maintenanceServicesImpl = maintenanceServicesImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<MaintenanceDTO> getAllMaintenance(){
        return maintenanceServicesImpl.findAll();
    }
    
    @GetMapping("/{id}")
    public  Optional findById(@PathVariable Long id){
        return maintenanceServicesImpl.findById(id);
    }
    
    @PostMapping
    public MaintenanceDTO createMaintenance(@RequestBody MaintenanceDTO maintenanceDTO){
        return maintenanceServicesImpl.save(maintenanceDTO);
    }
    
    @DeleteMapping("/{id}")
    public void deleteMaintenance(@PathVariable Long id){
        maintenanceServicesImpl.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public MaintenanceDTO updateMaintenance(@PathVariable Long id, @RequestBody MaintenanceDTO maintenanceDTO){
        maintenanceDTO.setId(id);
        return maintenanceServicesImpl.save(maintenanceDTO);
    }
    
}
