
package com.campus.novaair.classseat.domain;

import java.util.List;


public interface ClassSeatRepository {
    List<ClassSeat> findAll();
    ClassSeat save(ClassSeat classSeat);
    
}
