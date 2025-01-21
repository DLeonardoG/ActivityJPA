package com.campus.novaair.maintenances.infrastructure;

import com.campus.novaair.maintenances.domain.Maintenance;
import com.campus.novaair.maintenances.domain.MaintenanceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMaintenanceRepository extends JpaRepository<Maintenance, Long>, MaintenanceRepository {
}
