/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.plane.application;

import com.campus.novaair.plane.domain.Plane;
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
public class PlaneServiceImpl implements PlaneRepository{

     private final PlaneRepository planeRepository;
     
    public PlaneServiceImpl(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }
    
    @Override
    public List<Plane> findAll() {
        return planeRepository.findAll();
    }

    @Override
    public Plane save(Plane plane) {
        return planeRepository.save(plane);

    }

    @Override
    public Optional findById(Long id) {
        return planeRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        planeRepository.deleteById(id);
    }
    
    
}
