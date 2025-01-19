package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.ClassSeat;
import com.campus.activityjpa.model.repository.ClassSeatRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ClassSeatService {

    private final ClassSeatRepository classSeatRepository;

    public ClassSeatService(ClassSeatRepository classSeatRepository) {
        this.classSeatRepository = classSeatRepository;
    }
    
    public ClassSeat saveClassSeat( ClassSeat classSeat){
        return classSeatRepository.save(classSeat);
    }
    public List<ClassSeat> getAll(){
        return classSeatRepository.findAll();
    }
    
    public Optional<ClassSeat> getClassSeatById(Long id) {
        return classSeatRepository.findById(id);
    }
    public void deleteClassSeat(Long id) {
        classSeatRepository.deleteById(id);
    }

}
