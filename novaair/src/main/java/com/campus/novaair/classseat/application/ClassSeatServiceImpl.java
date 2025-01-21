package com.campus.novaair.classseat.application;

import com.campus.novaair.classseat.domain.ClassSeat;
import com.campus.novaair.classseat.domain.ClassSeatRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassSeatServiceImpl {

    private final ClassSeatRepository classSeatRepository;
    
    @Autowired
    public ClassSeatServiceImpl(ClassSeatRepository classSeatRepository) {
        this.classSeatRepository = classSeatRepository;
    }
    
    public List<ClassSeat> getAllClassSeat() {
       return classSeatRepository.findAll();
    }
    
    public ClassSeat saveClassSeat(ClassSeat classSeat) {
         return classSeatRepository.save(classSeat);
    }

}
