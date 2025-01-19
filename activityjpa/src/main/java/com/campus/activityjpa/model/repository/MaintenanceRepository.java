
package com.campus.activityjpa.model.repository;

import com.campus.activityjpa.model.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository  extends JpaRepository<Maintenance, Long> {
    
}
