package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.Airport;
import com.campus.activityjpa.model.entity.Flight;
import com.campus.activityjpa.model.entity.Flight;
import com.campus.activityjpa.model.entity.CrewMember;
import com.campus.activityjpa.model.entity.Flight;
import com.campus.activityjpa.model.entity.CrewMember;
import com.campus.activityjpa.model.entity.Plane;
import com.campus.activityjpa.model.repository.FlightRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    public Optional<Flight> findFlight(Long id) {
        return flightRepository.findById(id);
    }

    public void removeFlight(Long id) {
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

    // derivadas
    public List<Flight> getFlightsByAirports(Airport origin, Airport destination) {
        return flightRepository.findByOriginAndDestination(origin, destination);
    }

    public List<Flight> getFlightsByPlane(Plane plane) {
        return flightRepository.findByPlane(plane);
    }

    public List<Flight> getFlightsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return flightRepository.findByDateBetween(startDate, endDate);
    }

    public List<Flight> getFlightsByCrewMember(CrewMember crewMember) {
        return flightRepository.findByCrewMembers(crewMember);
    }

    public List<Flight> getFlightsBeforeDate(LocalDateTime date) {
        return flightRepository.findByDateBefore(date);
    }

    // --- con JPQL
    public List<Flight> getFlightsByMinimumTickets(int minTickets) {
        return flightRepository.findByTicketsWithMinimumSize(minTickets);
    }

    public List<Flight> getFlightsByOriginAndDestinationAfterDate(Airport origin, Airport destination, LocalDateTime date) {
        return flightRepository.findByOriginAndDestinationAfterDate(origin, destination, date);
    }

}
