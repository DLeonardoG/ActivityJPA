package com.campus.novaair.flight.application;

import com.campus.novaair.airport.domain.Airport;
import com.campus.novaair.airport.domain.AirportRepository;
import com.campus.novaair.crewmember.domain.CrewMember;
import com.campus.novaair.flight.domain.Flight;
import com.campus.novaair.flight.domain.FlightDTO;
import com.campus.novaair.flight.domain.FlightRepository;
import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.domain.PlaneRepository;
import com.campus.novaair.role.domain.Role;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl {

    private final FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDTO> findAll() {
        return flightRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FlightDTO save(FlightDTO flightDTO) {
        Flight flight = convertToEntity(flightDTO);
        Flight savedFlight = flightRepository.save(flight);
        return convertToDTO(flight);
    }

    public Optional<FlightDTO> findById(Long id) {
        return flightRepository.findById(id)
                .map(this::convertToDTO);
    }

    public void deleteById(Long id) {
        flightRepository.deleteById(id);
    }

    public Flight addCrewMemberwithFlight(Flight flight, List<CrewMember> crewMembers) {
        for (CrewMember crewMember : crewMembers) {
            flight.addCrewMember(crewMember);
        }
        return flightRepository.save(flight);
    }

    @Transactional
    public Flight addCrewMember(Flight flight, List<CrewMember> crewMembers) {
        for (CrewMember crewMember : crewMembers) {
            flight.addCrewMember(crewMember);
        }
        return flightRepository.save(flight);
    }

    private FlightDTO convertToDTO(Flight flight) {
        return new FlightDTO(
                flight.getId(),
                flight.getDate(),
                flight.getDateArrived(),
                flight.getOrigin().getName(),
                flight.getDestination().getName(),
                flight.getPlane().getName()
        );
    }

    private Flight convertToEntity(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setId(flightDTO.getId());
        flight.setDate(flightDTO.getDate());
        flight.setDateArrived(flightDTO.getDateArrived());

        Airport origin = airportRepository.findByName(flightDTO.getOrigin())
                .orElseThrow(() -> new IllegalArgumentException("flight not found: " + flightDTO.getOrigin()));
        flight.setOrigin(origin);
        Airport destination = airportRepository.findByName(flightDTO.getDestination())
                .orElseThrow(() -> new IllegalArgumentException("flight not found: " + flightDTO.getDestination()));
        flight.setDestination(destination);

        Plane plane = planeRepository.findByName(flightDTO.getPlane())
                .orElseThrow(() -> new IllegalArgumentException("plane not found: " + flightDTO.getPlane()));
        flight.setPlane(plane);
        return flight;
    }

}
