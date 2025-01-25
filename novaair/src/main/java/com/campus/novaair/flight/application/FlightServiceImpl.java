package com.campus.novaair.flight.application;

import com.campus.novaair.crewmember.domain.CrewMember;
import com.campus.novaair.flight.domain.Flight;
import com.campus.novaair.flight.domain.FlightRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlightServiceImpl implements FlightRepository {
    
    private final FlightRepository flightRepository;
    
    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    
    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight save(Flight airport) {
        return flightRepository.save(airport);

    }

    @Override
    public Optional findById(Long id) {
        return flightRepository.findById(id);
    }

    @Override
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
    
    
    
}
