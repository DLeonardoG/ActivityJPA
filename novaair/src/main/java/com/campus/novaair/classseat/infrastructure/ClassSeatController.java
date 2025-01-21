package com.campus.novaair.classseat.infrastructure;

import com.campus.novaair.classseat.application.ClassSeatServiceImpl;
import com.campus.novaair.classseat.domain.ClassSeat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/classseat")
public class ClassSeatController {
    private final ClassSeatServiceImpl classSeatServiceImpl;
    
    @Autowired
    public ClassSeatController (ClassSeatServiceImpl classSeatServiceImpl){
        this.classSeatServiceImpl = classSeatServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ClassSeat> getAllClassSeat(){
        return classSeatServiceImpl.getAllClassSeat();
    } 
}
