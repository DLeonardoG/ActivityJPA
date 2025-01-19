package com.campus.activityjpa;

import com.campus.activityjpa.controller.AirportService;
import com.campus.activityjpa.controller.ClassSeatService;
import com.campus.activityjpa.controller.FlightService;
import com.campus.activityjpa.controller.MaintenanceService;
import com.campus.activityjpa.controller.PassengerService;
import com.campus.activityjpa.controller.PayMethodService;
import com.campus.activityjpa.controller.PlaceService;
import com.campus.activityjpa.controller.PlaneService;
import com.campus.activityjpa.controller.RoleService;
import com.campus.activityjpa.controller.TicketService;
import com.campus.activityjpa.controller.TypeMaintenanceService;
import com.campus.activityjpa.model.entity.Airport;
import com.campus.activityjpa.model.entity.ClassSeat;
import com.campus.activityjpa.model.entity.Flight;
import com.campus.activityjpa.model.entity.Maintenance;
import com.campus.activityjpa.model.entity.Passenger;
import com.campus.activityjpa.model.entity.PayMethod;
import com.campus.activityjpa.model.entity.Place;
import com.campus.activityjpa.model.entity.Plane;
import com.campus.activityjpa.model.entity.Role;
import com.campus.activityjpa.model.entity.Ticket;
import com.campus.activityjpa.model.entity.TypeMaintenance;
import com.campus.activityjpa.model.repository.ClassSeatRepository;
import java.time.LocalDate;
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

//            --- Creation of a new role ---
//            RoleService roleService = context.getBean(RoleService.class);
//            Role newRole = roleService.saveRole(hostess"");
//            System.out.println("h0  "+newRole);
           
//        --- creation of a new crew member from role ---
//        Map<String, String> members = new HashMap<>();
//        members.put("1", "camilo");
//        members.put("2", "clros");
//        members.put("1", "mafer");
        
//        members.forEach((key, value) -> System.out.println("id: " + key + ", name: " + value));
//        roleService.saveRoleWithCrewMembers("pilot", members);
//        roleService.getAll().forEach(System.out::println);

//          --- Types y mainteneces relationShip ---
        TypeMaintenanceService typeMaintenanceService = context.getBean(TypeMaintenanceService.class);
        MaintenanceService maintenanceService = context.getBean(MaintenanceService.class);
        
        TypeMaintenance typeMaintenance1 = new TypeMaintenance("Alas", 100.0);
        TypeMaintenance typeMaintenance2 = new TypeMaintenance("llantas", 200.0);
        
        typeMaintenanceService.saveTypeMaintenance(typeMaintenance1);
        typeMaintenanceService.saveTypeMaintenance(typeMaintenance2);
        
        LocalDate currentDate = LocalDate.now();
        Maintenance maintenance1 = new Maintenance(currentDate, 100.0);
        Maintenance maintenance2 = new Maintenance(currentDate, 200.0);
        
        List<TypeMaintenance> typesMaintenenceMaintenence1 = new ArrayList<>();
        typesMaintenenceMaintenence1.add(typeMaintenance1);
        typesMaintenenceMaintenence1.add(typeMaintenance2);
        
        List<TypeMaintenance> typesMaintenenceMaintenence2 = new ArrayList<>();
        typesMaintenenceMaintenence2.add(typeMaintenance1);
        
        maintenanceService.addTypeMaintenance(maintenance1, typesMaintenenceMaintenence1);
        maintenanceService.addTypeMaintenance(maintenance2, typesMaintenenceMaintenence2);
        
//        --- OneToOne Manintenance with plane ---
        PlaneService planeService = context.getBean(PlaneService.class);
        
        Plane plane1 = new Plane("2023", 50);
        Maintenance maintenance3 = new Maintenance(currentDate, 700.0, plane1);
        
        plane1.setMaintenance(maintenance3);
        planeService.savePlane(plane1);
        
        List<TypeMaintenance> typesMaintenenceMaintenence3 = new ArrayList<>();
        typesMaintenenceMaintenence3.add(typeMaintenance1);
        maintenanceService.addTypeMaintenance(maintenance3, typesMaintenenceMaintenence3);

//        --- OneToOne place with airport---
        PlaceService placeService = context.getBean(PlaceService.class);
        AirportService airportService = context.getBean(AirportService.class);

        Airport airport1 = new Airport("vivaMexico");
        Airport airport2 = new Airport("AlaMadrid");
        
        Place place1 = new Place("tijuacana", airport1);
        Place place2 = new Place("madrid", airport2);
        
        airport1.setPlace(place1);
        airport2.setPlace(place2);
        
        airportService.saveAirport(airport1);
        airportService.saveAirport(airport2);

//        --- OneToMany passenger with ticket---
        PassengerService passengerService = context.getBean(PassengerService.class);
        TicketService ticketService = context.getBean(TicketService.class); 
        ClassSeatService classSeatService = context.getBean(ClassSeatService.class); 
        PayMethodService payMethodService = context.getBean(PayMethodService.class); 
        FlightService flightService = context.getBean(FlightService.class); 
        
        ClassSeat classSeat1 = new ClassSeat(500, "VIP");
        ClassSeat classSeat2 = new ClassSeat(100, "1");
        
        
        Flight flight1 = new Flight(currentDate, currentDate);
        
        PayMethod payMethod1 = new PayMethod("Nqui");
        
        Passenger passenger1 = new Passenger("123", "Marcus");
        
        
        classSeatService.saveClassSeat(classSeat1);
        flightService.saveFlight(flight1);
        payMethodService.savePayMethod(payMethod1);
        passengerService.savePassenger(passenger1);
        
        
        Ticket ticket1 = new Ticket(currentDate, currentDate, "A2");
        Ticket ticket2 = new Ticket(currentDate, currentDate, "A3");
        
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
