package com.campus.activityjpa;

import com.campus.activityjpa.controller.*;
import com.campus.activityjpa.model.entity.*;
import com.campus.activityjpa.model.repository.PlaneRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ActivityjpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ActivityjpaApplication.class, args);
        
        PassengerService passengerService = context.getBean(PassengerService.class);
        TicketService ticketService = context.getBean(TicketService.class); 
        ClassSeatService classSeatService = context.getBean(ClassSeatService.class); 
        PayMethodService payMethodService = context.getBean(PayMethodService.class); 
        FlightService flightService = context.getBean(FlightService.class);
        TypeMaintenanceService typeMaintenanceService = context.getBean(TypeMaintenanceService.class);
        MaintenanceService maintenanceService = context.getBean(MaintenanceService.class);
        PlaneService planeService = context.getBean(PlaneService.class);
        PlaceService placeService = context.getBean(PlaceService.class);
        AirportService airportService = context.getBean(AirportService.class);
        RoleService roleService = context.getBean(RoleService.class);
        CrewMemberService crewMemberService = context.getBean(CrewMemberService.class);

//            --- creation of a new role ---
        roleService.saveRole("hostess");
        
//          --- creation of a new crew member from role ---
        Map<String, String> members = new HashMap<>();
        members.put("1", "camilo");
        members.put("2", "clros");
        members.put("1", "mafer");
        
        roleService.saveRoleWithCrewMembers("pilot", members);
        
        Role role2 = new Role("Someone");
        roleService.save(role2);

        CrewMember crewMember1 = new CrewMember("233", "Bertha");
        CrewMember crewMember2 = new CrewMember("2334", "Bertho");
        crewMember1.setRole(role2);
        crewMember2.setRole(role2);
        crewMemberService.saveCrewMember(crewMember1);
        crewMemberService.saveCrewMember(crewMember2);
        
        
        LocalDateTime dateDeparture = LocalDateTime.of(2025, 3, 15, 14, 30);
        LocalDateTime dateArrived = LocalDateTime.of(2025, 3, 19, 14, 30);
        Flight flight3 = new Flight(dateDeparture, dateArrived);
        
        
        
        List <CrewMember> crewList = new ArrayList<>();
        crewList.add(crewMember2);
        
        
        flightService.addCrewMember(flight3, crewList);
        flightService.saveFlight(flight3);

        
//        LocalDateTime startDateTime = LocalDateTime.of(2025, 1, 14, 8, 0);
//        LocalDateTime endDateTime = LocalDateTime.of(2025, 1, 20, 20, 0);

//        List<Flight> flights = flightService.getFlightsByDepartureDateTimeRange(startDateTime, endDateTime);

//        flights.forEach(System.out::println);
        
        TypeMaintenance typeMaintenance1 = new TypeMaintenance("Alas", 100.0);
        TypeMaintenance typeMaintenance2 = new TypeMaintenance("llantas", 200.0);
        typeMaintenanceService.saveTypeMaintenance(typeMaintenance1);
        typeMaintenanceService.saveTypeMaintenance(typeMaintenance2);
        
        LocalDate currentDate = LocalDate.now();
        Maintenance maintenance1 = new Maintenance(currentDate, 100.0);
        Maintenance maintenance2 = new Maintenance(currentDate, 200.0);
        
        Airport airport1 = new Airport("vivaMexico");
        Airport airport2 = new Airport("AlaMadrid");
        
        Place place1 = new Place("tijuacana", airport1);
        Place place2 = new Place("madrid", airport2);
        
        Plane plane1 = new Plane("2023", 50);
        Maintenance maintenance3 = new Maintenance(currentDate, 700.0, plane1);
        
      
        
        ClassSeat classSeat1 = new ClassSeat(500, "VIP");
        ClassSeat classSeat2 = new ClassSeat(100, "1");
        
        Flight flight1 = new Flight(dateDeparture, dateArrived);
        
        PayMethod payMethod1 = new PayMethod("Nqui");
        
        Passenger passenger1 = new Passenger("123", "Marcus");
        
        Ticket ticket1 = new Ticket(currentDate, currentDate, "A2");
        Ticket ticket2 = new Ticket(currentDate, currentDate, "A3");
        
        
        
        
        airport1.setPlace(place1);
        airport2.setPlace(place2);
        
        airportService.saveAirport(airport1);
        airportService.saveAirport(airport2);
        
        flight3.setOrigin(airport2);
        flight3.setDestination(airport1);
        flightService.saveFlight(flight3);
        
        
        
        
       
        
        List<TypeMaintenance> typesMaintenenceMaintenence1 = new ArrayList<>();
        typesMaintenenceMaintenence1.add(typeMaintenance1);
        typesMaintenenceMaintenence1.add(typeMaintenance2);
        
        List<TypeMaintenance> typesMaintenenceMaintenence2 = new ArrayList<>();
        typesMaintenenceMaintenence2.add(typeMaintenance1);
        
        maintenanceService.addTypeMaintenance(maintenance1, typesMaintenenceMaintenence1);
        maintenanceService.addTypeMaintenance(maintenance2, typesMaintenenceMaintenence2);
        
//        --- OneToOne Manintenance with plane ---
        
       
        
        plane1.setMaintenance(maintenance3);
        planeService.savePlane(plane1);
        
        
        flight3.setPlane(plane1);
        
        flightService.saveFlight(flight3);
        
        List<TypeMaintenance> typesMaintenenceMaintenence3 = new ArrayList<>();
        typesMaintenenceMaintenence3.add(typeMaintenance1);
        maintenanceService.addTypeMaintenance(maintenance3, typesMaintenenceMaintenence3);

//        --- OneToOne place with airport---
        


        


//        --- OneToMany passenger with ticket---
 
        
 
        
        
        classSeatService.saveClassSeat(classSeat1);
        flightService.saveFlight(flight1);
        payMethodService.savePayMethod(payMethod1);
        passengerService.savePassenger(passenger1);
        
        

        
        ticket1.setClassSeat(classSeat1);
        ticket1.setFlight(flight1);
        ticket1.setPayMethod(payMethod1);
        ticket1.setPassenger(passenger1);
        
        
        ticketService.saveTicket(ticket1);
        
       
        
//        List<Ticket> tickets1 = new ArrayList<>();
//        tickets1.add(ticket1);
//        
//        passengerService.addTickets(passenger1, tickets1);
        
        
    }

}
