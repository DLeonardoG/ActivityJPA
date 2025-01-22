/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.plane.application;

import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.domain.PlaneRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class PlaneServiceImpl {

     private final PlaneRepository planeRepository;
     
    public PlaneServiceImpl(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }
    
    public Plane savePlane( Plane plane){
        return planeRepository.save(plane);
    }
    
    public List<Plane> getAllPlanes(){
        return planeRepository.findAll();
    }
    
//     public Optional<Plane> findPlane (Long id){
//        return planeRepository.findById(id);
//    }
//    
//    public void removePlane (Long id){
//        planeRepository.deleteById(id);
//    }
}
