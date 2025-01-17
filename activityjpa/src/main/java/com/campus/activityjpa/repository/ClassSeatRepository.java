
package com.campus.activityjpa.repository;

import com.campus.activityjpa.model.entity.ClassSeat;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface class ClassSeatRepository extends JpaRepository<ClassSeat, Long>{
    
}