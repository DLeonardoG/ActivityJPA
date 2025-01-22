/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.place.infrastructure;

import com.campus.novaair.place.application.PlaceServiceImpl;
import com.campus.novaair.place.domain.Place;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kevin
 */
@RestController
@RequestMapping("/api/place")
public class PlaceController {
    
    private final PlaceServiceImpl placeServiceImpl;
    
    @Autowired
    public PlaceController(PlaceServiceImpl placeServiceImpl){
        this.placeServiceImpl = placeServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Place> getAllRoles(){
        return placeServiceImpl.getAllPlace();
    }
    
}
