package com.campus.novaair.classseat.infrastructure;

import com.campus.novaair.classseat.domain.ClassSeat;
import com.campus.novaair.classseat.domain.ClassSeatRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaClassSeatRepository extends JpaRepository<ClassSeat, Long>, ClassSeatRepository{
    Optional<ClassSeat> findById(Long id);
}
