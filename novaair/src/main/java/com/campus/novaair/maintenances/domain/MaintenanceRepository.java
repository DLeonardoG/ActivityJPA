package com.campus.novaair.maintenances.domain;


import java.util.List;
import java.util.Optional;


public interface MaintenanceRepository {
    List<Maintenance> findAll();
    Maintenance save(Maintenance maintenance);
    Optional<Maintenance> findById(Long id);
    void deleteById(Long id);
}
