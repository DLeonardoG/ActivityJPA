package com.campus.novaair.maintenances.domain;

import java.util.List;


public interface MaintenanceRepository {
    List<Maintenance> findAll();
    Maintenance save(Maintenance maintenance);
    
}
