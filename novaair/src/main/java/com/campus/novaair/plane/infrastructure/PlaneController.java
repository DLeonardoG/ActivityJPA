/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.plane.infrastructure;

import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.application.PlaneServiceImpl;
import com.campus.novaair.plane.domain.Plane;
import java.util.List;
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


/**
 *
 * @author kevin
 */
    @RestController
    @RequestMapping("/api/plane")
public class PlaneController {

    

    private final PlaneServiceImpl planeServiceImpl;

    @Autowired
    public PlaneController(PlaneServiceImpl planeServiceImpl) {
        this.planeServiceImpl = planeServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Plane> getAllPlanes() {
        return planeServiceImpl.findAll();
    }
    @PostMapping
    public Plane createPlane(@RequestBody Plane plane){
        return planeServiceImpl.save(plane);
    }
    
    @DeleteMapping("/{id}")
    public void deletePlane(@PathVariable Long id){
        planeServiceImpl.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Plane updatePlane(@PathVariable Long id, @RequestBody Plane plane){
        plane.setId(id);
        return planeServiceImpl.save(plane);
    }

}
