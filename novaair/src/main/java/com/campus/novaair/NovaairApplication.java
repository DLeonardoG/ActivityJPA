package com.campus.novaair;

import com.campus.novaair.airport.application.AirportServiceImpl;
import com.campus.novaair.airport.domain.Airport;
import com.campus.novaair.classseat.application.ClassSeatServiceImpl;
import com.campus.novaair.classseat.domain.ClassSeat;
import com.campus.novaair.crewmember.application.CrewMemberServiceImpl;
import com.campus.novaair.crewmember.domain.CrewMember;
import com.campus.novaair.endpoint.application.EndPointServiceImpl;
import com.campus.novaair.endpoint.domain.EndPoint;
import com.campus.novaair.flight.application.FlightServiceImpl;
import com.campus.novaair.flight.domain.Flight;
import com.campus.novaair.maintenances.application.MaintenanceServiceImpl;
import com.campus.novaair.maintenances.domain.Maintenance;
import com.campus.novaair.passangers.application.PassengerServiceImpl;
import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.paymethod.application.PayMethodServiceImpl;
import com.campus.novaair.paymethod.domain.PayMethod;
import com.campus.novaair.place.application.PlaceServiceImpl;
import com.campus.novaair.place.domain.Place;
import com.campus.novaair.plane.application.PlaneServiceImpl;
import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.role.application.RoleServiceImpl;
import com.campus.novaair.ticket.application.TicketServiceImpl;
import com.campus.novaair.ticket.domain.Ticket;
import com.campus.novaair.role.domain.Role;
import com.campus.novaair.typemaintenance.application.TypeMaintenanceServiceImpl;
import com.campus.novaair.typemaintenance.domain.TypeMaintenance;
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
public class NovaairApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(NovaairApplication.class, args);

        PassengerServiceImpl passengerServiceImpl = context.getBean(PassengerServiceImpl.class);
        TicketServiceImpl ticketServiceImpl = context.getBean(TicketServiceImpl.class);
        ClassSeatServiceImpl classSeatServiceImpl = context.getBean(ClassSeatServiceImpl.class);
        PayMethodServiceImpl payMethodServiceImpl = context.getBean(PayMethodServiceImpl.class);
        FlightServiceImpl flightServiceImpl = context.getBean(FlightServiceImpl.class);
        TypeMaintenanceServiceImpl typeMaintenanceServiceImpl = context.getBean(TypeMaintenanceServiceImpl.class);
        MaintenanceServiceImpl maintenanceServiceImpl = context.getBean(MaintenanceServiceImpl.class);
        PlaneServiceImpl planeServiceImpl = context.getBean(PlaneServiceImpl.class);
        PlaceServiceImpl placeServiceImpl = context.getBean(PlaceServiceImpl.class);
        AirportServiceImpl airportServiceImpl = context.getBean(AirportServiceImpl.class);
        RoleServiceImpl roleServiceImpl = context.getBean(RoleServiceImpl.class);
        CrewMemberServiceImpl crewMemberServiceImpl = context.getBean(CrewMemberServiceImpl.class);

//            --- creation of a new role ---
//        roleServiceImpl.save("hostess");

//          --- creation of a new crew member from role ---
        Map<String, String> members = new HashMap<>();
        members.put("1", "camilo");
        members.put("2", "clros");
        members.put("1", "mafer");

//        roleServiceImpl.saveWithCrewMembers("pilot", members);

        Role role2 = new Role("Someone");
        roleServiceImpl.save(role2);

        CrewMember crewMember1 = new CrewMember("233", "Bertha");
        CrewMember crewMember2 = new CrewMember("2334", "Bertho");
        crewMember1.setRole(role2);
        crewMember2.setRole(role2);
        crewMemberServiceImpl.save(crewMember1);
        crewMemberServiceImpl.save(crewMember2);

        LocalDateTime dateDeparture = LocalDateTime.of(2025, 3, 15, 14, 30);
        LocalDateTime dateArrived = LocalDateTime.of(2025, 3, 19, 14, 30);
        Flight flight3 = new Flight(dateDeparture, dateArrived);

        List<CrewMember> crewList = new ArrayList<>();
        crewList.add(crewMember2);

        flightServiceImpl.addCrewMember(flight3, crewList);
        flightServiceImpl.save(flight3);

        LocalDate currentDate = LocalDate.now();

        TypeMaintenance typeMaintenance1 = new TypeMaintenance("Alas", 100.0);
        TypeMaintenance typeMaintenance2 = new TypeMaintenance("llantas", 200.0);
        typeMaintenanceServiceImpl.save(typeMaintenance1);
        typeMaintenanceServiceImpl.save(typeMaintenance2);

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
        
        LocalDateTime currentDateTime = LocalDateTime.now();


        Ticket ticket1 = new Ticket(currentDateTime, currentDateTime, "A2");
        Ticket ticket2 = new Ticket(currentDateTime, currentDateTime, "A3");

        airport1.setPlace(place1);
        airport2.setPlace(place2);

        airportServiceImpl.save(airport1);
        airportServiceImpl.save(airport2);

        flight3.setOrigin(airport2);
        flight3.setDestination(airport1);
        flightServiceImpl.save(flight3);

        List<TypeMaintenance> typesMaintenenceMaintenence1 = new ArrayList<>();
        typesMaintenenceMaintenence1.add(typeMaintenance1);
        typesMaintenenceMaintenence1.add(typeMaintenance2);

        List<TypeMaintenance> typesMaintenenceMaintenence2 = new ArrayList<>();
        typesMaintenenceMaintenence2.add(typeMaintenance1);

        maintenanceServiceImpl.addTypeMaintenance(maintenance1, typesMaintenenceMaintenence1);
        maintenanceServiceImpl.addTypeMaintenance(maintenance2, typesMaintenenceMaintenence2);

//        --- OneToOne Manintenance with plane ---
        plane1.setMaintenance(maintenance3);
        planeServiceImpl.save(plane1);

        flight3.setPlane(plane1);

        flightServiceImpl.save(flight3);

        List<TypeMaintenance> typesMaintenenceMaintenence3 = new ArrayList<>();
        typesMaintenenceMaintenence3.add(typeMaintenance1);
        maintenanceServiceImpl.addTypeMaintenance(maintenance3, typesMaintenenceMaintenence3);

//        --- OneToMany passenger with ticket ---
        classSeatServiceImpl.save(classSeat1);
        flightServiceImpl.save(flight1);
        payMethodServiceImpl.save(payMethod1);
        passengerServiceImpl.save(passenger1);

        ticket1.setClassSeat(classSeat1);
        ticket1.setFlight(flight1);
        ticket1.setPayMethod(payMethod1);
        ticket1.setPassenger(passenger1);

        ticketServiceImpl.save(ticket1);

    }

}
