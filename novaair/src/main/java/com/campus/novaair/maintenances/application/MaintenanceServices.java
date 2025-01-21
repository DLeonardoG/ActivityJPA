package com.campus.novaair.maintenances.application;

import com.campus.novaair.maintenances.domain.Maintenance;
import java.util.List;

public interface MaintenanceServices {
   List<Maintenance> getAllMaintenance();
   Maintenance getMaintenanceById(Long id);
   Maintenance saveMaintenance(Maintenance maintenance);
   void deleteMaintenance(Long id);
    
}
