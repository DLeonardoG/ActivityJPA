
package com.campus.novaair.plane.application;

import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.domain.PlaneDTO;
import com.campus.novaair.plane.domain.PlaneRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PlaneServiceImpl {
    private final PlaneRepository planeRepository;
     
    public PlaneServiceImpl(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }
    
    public List<PlaneDTO> findAll() {
        return planeRepository.findAll().stream()
          .map(this::convertToDTO)
              .collect(Collectors.toList());
    }
    
    public PlaneDTO save(PlaneDTO planeDTO) {
        Plane plane = convertToEntity(planeDTO);
        Plane savaedPlane = planeRepository.save(plane);
        return convertToDTO((savaedPlane));

    }
    
    public Optional<PlaneDTO> findById(Long id) {
        return planeRepository.findById(id)
                 .map(this::convertToDTO);
    }
    
    public void deleteById(Long id) {
        planeRepository.deleteById(id);
    }
    
        private PlaneDTO convertToDTO(Plane plane) {
        return new PlaneDTO(
                plane.getId(),
                plane.getModel(), 
                plane.getNumSeat(),
                plane.getName()
        );
    }

    private Plane convertToEntity(PlaneDTO planeDTO) {
        Plane plane = new Plane(
                planeDTO.getId(),
                planeDTO.getModel(),
                planeDTO.getNumSeat(),
                planeDTO.getName()
        );
        return plane;
    }
    
}
