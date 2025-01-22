
package com.campus.novaair.classseat.domain;

import java.util.List;
import java.util.Optional;


public interface ClassSeatRepository {
    List<ClassSeat> findAll();
    ClassSeat save(ClassSeat classSeat);
    Optional<ClassSeat> findById(Long id);
    void deleteById(Long id);
}
