package com.campus.novaair.classseat.application;

import com.campus.novaair.classseat.domain.ClassSeat;
import com.campus.novaair.classseat.domain.ClassSeat;
import com.campus.novaair.classseat.domain.ClassSeatDTO;
import com.campus.novaair.classseat.domain.ClassSeatRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassSeatServiceImpl{

    private final ClassSeatRepository classSeatRepository;
    
    @Autowired
    public ClassSeatServiceImpl(ClassSeatRepository classSeatRepository) {
        this.classSeatRepository = classSeatRepository;
    }
    
    public List<ClassSeatDTO> findAll() {
      return classSeatRepository.findAll().stream()
              .map(this::convertToDTO)
              .collect(Collectors.toList());
    }
    
    public ClassSeatDTO save(ClassSeatDTO classSeatDTO) {
    ClassSeat classSeat = convertToEntity(classSeatDTO);
    ClassSeat savedClassSeat = classSeatRepository.save(classSeat);
    return convertToDTO(savedClassSeat);
}
     public Optional<ClassSeatDTO> findById(Long id) {
        return classSeatRepository.findById(id)
                .map(this::convertToDTO);
    }
     
    public void deleteById(Long id) {
        classSeatRepository.deleteById(id);
    }

    private ClassSeatDTO convertToDTO(ClassSeat classSeat) {
        return new ClassSeatDTO(classSeat.getId(),
                classSeat.getPrice(), 
                classSeat.getSeatClass());
    }

    private ClassSeat convertToEntity(ClassSeatDTO classSeatDTO) {
        ClassSeat classSeat = new ClassSeat(classSeatDTO.getId(),
                classSeatDTO.getPrice(),
                classSeatDTO.getSeatClass());
        return classSeat;
    }
    
    
    
}
