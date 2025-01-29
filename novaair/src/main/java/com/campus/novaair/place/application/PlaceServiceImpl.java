/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.place.application;


import com.campus.novaair.place.domain.Place;
import com.campus.novaair.place.domain.PlaceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class PlaceServiceImpl{
    
    private final PlaceRepository placeRepository;
    
    public PlaceServiceImpl (PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
    }
    public List<Place> findAll() {
        return placeRepository.findAll();
    }
    public Place save(Place place) {
        return placeRepository.save(place);

    }
    public Optional findById(Long id) {
        return placeRepository.findById(id);
    }
    public void deleteById(Long id) {
        placeRepository.deleteById(id);
    }
     
    
    

}
