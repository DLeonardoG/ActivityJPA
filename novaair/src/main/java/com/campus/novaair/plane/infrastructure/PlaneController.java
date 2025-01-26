
package com.campus.novaair.plane.infrastructure;

import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.application.PlaneServiceImpl;
import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.domain.PlaneDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/planes")
public class PlaneController {

    

    private final PlaneServiceImpl planeServiceImpl;

    @Autowired
    public PlaneController(PlaneServiceImpl planeServiceImpl) {
        this.planeServiceImpl = planeServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PlaneDTO> getAllPlanes() {
        return planeServiceImpl.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional findById(@PathVariable Long id){
        return planeServiceImpl.findById(id);
    }
    
    @PostMapping
    public PlaneDTO createPlane(@RequestBody PlaneDTO planeDTO){
        return planeServiceImpl.save(planeDTO);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id){
        planeServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public PlaneDTO updatePlane(@PathVariable Long id, @RequestBody PlaneDTO planeDTO){
        planeDTO.setId(id);
        return planeServiceImpl.save(planeDTO);
    }

}
