
package com.campus.novaair.place.infrastructure;

import com.campus.novaair.place.application.PlaceServiceImpl;
import com.campus.novaair.place.domain.Place;
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

@RestController
@RequestMapping("/api/places")
public class PlaceController {
    
    private final PlaceServiceImpl placeServiceImpl;
    
    @Autowired
    public PlaceController(PlaceServiceImpl placeServiceImpl){
        this.placeServiceImpl = placeServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Place> getAllRoles(){
        return placeServiceImpl.findAll();
    }
    
    @PostMapping
    public Place createPlace(@RequestBody Place place){
        return placeServiceImpl.save(place);
    }
    
    @DeleteMapping("/{id}")
    public void deletePlace(@PathVariable Long id){
        placeServiceImpl.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Place updatePlace(@PathVariable Long id, @RequestBody Place place){
        place.setId(id);
        return placeServiceImpl.save(place);
    }
    
    
}
