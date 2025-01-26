package com.campus.novaair.airport.application;

import com.campus.novaair.airport.domain.Airport;
import com.campus.novaair.airport.domain.AirportDTO;
import com.campus.novaair.airport.domain.AirportRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl{

    private final AirportRepository airportRepository;

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }
    
    public List<AirportDTO> findAll() {
       return airportRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
  public AirportDTO save(AirportDTO airportDTO) {
        Airport airport = convertToEntity(airportDTO);
        Airport savedAirport = airportRepository.save(airport);
        return convertToDTO(savedAirport);
    }



    public Optional<AirportDTO> findById(Long id) {
        return airportRepository.findById(id)
                .map(this::convertToDTO);
    }
    
    public void deleteById(Long id) {
        airportRepository.deleteById(id);
    }
    
      private AirportDTO convertToDTO(Airport airport) {
        return new AirportDTO(
                airport.getId(),
                airport.getName(),
                airport.getPlace());     
    }

private Airport convertToEntity(AirportDTO airportDTO) {
    Airport airport = new Airport(
            airportDTO.getId(),
            airportDTO.getName(), 
            airportDTO.getPlace());
    
    return airport;
}

}
