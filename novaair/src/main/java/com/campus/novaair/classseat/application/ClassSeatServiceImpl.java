package com.campus.novaair.classseat.application;

import com.campus.novaair.classseat.domain.ClassSeat;
import com.campus.novaair.classseat.domain.ClassSeat;
import com.campus.novaair.classseat.domain.ClassSeatRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassSeatServiceImpl implements ClassSeatRepository{

    private final ClassSeatRepository classSeatRepository;
    
    @Autowired
    public ClassSeatServiceImpl(ClassSeatRepository classSeatRepository) {
        this.classSeatRepository = classSeatRepository;
    }
    
    @Override
    public List<ClassSeat> findAll() {
        return classSeatRepository.findAll();
    }

    @Override
    public ClassSeat save(ClassSeat classSeat) {
        return classSeatRepository.save(classSeat);
    }

    @Override
    public Optional findById(Long id) {
        return classSeatRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        classSeatRepository.deleteById(id);
    }
    
    
    
}
