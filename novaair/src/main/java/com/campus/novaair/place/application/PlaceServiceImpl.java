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
public class PlaceServiceImpl {
    
    private final PlaceRepository placeRepository;
    
    public PlaceServiceImpl (PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
    }
     
    public Place savePlace( Place place){
        return placeRepository.save(place);
    }
    
    public List<Place> getAll(){
        return placeRepository.findAll();
    }
    
//    public Optional<Place> findPlace (Long id){
//        return placeRepository.findAll(id);
//    }
    
//    public void removePlace (Long id){
//        placeRepository.deleteById(id);
//    }
    
    public List<Place> getAllPlace(){
        return placeRepository.findAll();
    }
    

}
