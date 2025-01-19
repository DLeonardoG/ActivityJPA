
package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.Plane;
import com.campus.activityjpa.model.repository.PlaneRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlaneService {

     private final PlaneRepository planeRepository;
     
    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }
    
    public Plane savePlane( Plane plane){
        return planeRepository.save(plane);
    }
    
    public List<Plane> getAll(){
        return planeRepository.findAll();
    }
}
