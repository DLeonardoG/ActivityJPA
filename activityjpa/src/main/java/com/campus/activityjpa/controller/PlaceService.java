
package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.Place;
import com.campus.activityjpa.model.repository.PlaceRepository;
import com.campus.activityjpa.model.repository.PlaneRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;
    
    public PlaceService (PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
    }
     
    public Place savePlace( Place place){
        return placeRepository.save(place);
    }
    
    public List<Place> getAll(){
        return placeRepository.findAll();
    }
    
    public Optional<Place> findPlace (Long id){
        return placeRepository.findById(id);
    }
    
    public void removePlace (Long id){
        placeRepository.deleteById(id);
    }
}
