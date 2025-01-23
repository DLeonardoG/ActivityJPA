package com.campus.novaair.classseat.infrastructure;

import com.campus.novaair.airport.domain.Airport;
import com.campus.novaair.classseat.application.ClassSeatServiceImpl;
import com.campus.novaair.classseat.domain.ClassSeat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/classseats")
public class ClassSeatController {
    private final ClassSeatServiceImpl classSeatServiceImpl;
    
    @Autowired
    public ClassSeatController (ClassSeatServiceImpl classSeatServiceImpl){
        this.classSeatServiceImpl = classSeatServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ClassSeat> getAllClassSeat(){
        return classSeatServiceImpl.findAll();
    } 
    
    @GetMapping("/{id}")
    public Optional findById(@PathVariable Long id){
        return classSeatServiceImpl.findById(id);
    }
    
    @PostMapping
    public ClassSeat createClassSeat(@RequestBody ClassSeat classSeat){
        return classSeatServiceImpl.save(classSeat);
    }
    @DeleteMapping("/{id}")
    public void deleteClassSeat(@PathVariable Long id){
        classSeatServiceImpl.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public ClassSeat updateClassSeat(@PathVariable Long id, @RequestBody ClassSeat classSeat){
        classSeat.setId(id);
        return classSeatServiceImpl.save(classSeat);
    }
    
    
}
