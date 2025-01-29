package com.campus.novaair;

import com.campus.novaair.airport.application.AirportServiceImpl;
import com.campus.novaair.airport.domain.AirportDTO;
import com.campus.novaair.classseat.application.ClassSeatServiceImpl;
import com.campus.novaair.classseat.domain.ClassSeat;
import com.campus.novaair.classseat.domain.ClassSeatDTO;
import com.campus.novaair.crewmember.application.CrewMemberServiceImpl;
import com.campus.novaair.crewmember.domain.CrewMember;
import com.campus.novaair.crewmember.domain.CrewMemberDTO;
import com.campus.novaair.endpoint.application.EndPointServiceImpl;
import com.campus.novaair.endpoint.domain.EndPoint;
import com.campus.novaair.flight.application.FlightServiceImpl;
import com.campus.novaair.flight.domain.Flight;
import com.campus.novaair.flight.domain.FlightDTO;
import com.campus.novaair.maintenances.application.MaintenanceServiceImpl;
import com.campus.novaair.maintenances.domain.Maintenance;
import com.campus.novaair.maintenances.domain.MaintenanceDTO;
import com.campus.novaair.passangers.application.PassengerServiceImpl;
import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.passangers.domain.PassengerDTO;
import com.campus.novaair.paymethod.application.PayMethodServiceImpl;
import com.campus.novaair.paymethod.domain.PayMethod;
import com.campus.novaair.place.application.PlaceServiceImpl;
import com.campus.novaair.place.domain.Place;
import com.campus.novaair.plane.application.PlaneServiceImpl;
import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.domain.PlaneDTO;
import com.campus.novaair.role.application.RoleServiceImpl;
import com.campus.novaair.ticket.application.TicketServiceImpl;
import com.campus.novaair.ticket.domain.Ticket;
import com.campus.novaair.role.domain.Role;
import com.campus.novaair.role.domain.RoleDTO;
import com.campus.novaair.ticket.domain.TicketDTO;
import com.campus.novaair.typemaintenance.application.TypeMaintenanceServiceImpl;
import com.campus.novaair.typemaintenance.domain.TypeMaintenance;
import com.campus.novaair.typemaintenance.domain.TypeMaintenanceDTO;
import com.campus.novaair.user.application.UserServiceImpl;
import com.campus.novaair.user.domain.User;
import com.campus.novaair.user.domain.UserDTO;
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
        AirportServiceImpl airportServiceImpl = context.getBean(AirportServiceImpl.class);
        RoleServiceImpl roleServiceImpl = context.getBean(RoleServiceImpl.class);
        CrewMemberServiceImpl crewMemberServiceImpl = context.getBean(CrewMemberServiceImpl.class);
        UserServiceImpl useServiceImpl = context.getBean(UserServiceImpl.class);

//            --- creation of a new role ---
//        roleServiceImpl.save("hostess");

//          --- creation of a new crew member from role ---
//        Map<String, String> members = new HashMap<>();
//        members.put("1", "camilo");
//        members.put("2", "clros");
//        members.put("1", "mafer");

//        roleServiceImpl.saveWithCrewMembers("pilot", members);

        RoleDTO role2 = new RoleDTO("Someone");
        roleServiceImpl.save(role2);

        CrewMemberDTO crewMember1 = new CrewMemberDTO("233", "Bertha","Someone");
        CrewMemberDTO crewMember2 = new CrewMemberDTO("2334", "Bertho", "Someone");
        crewMember1.setRoleName(role2.getRole());
        crewMember2.setRoleName(role2.getRole());
        crewMemberServiceImpl.save(crewMember1);
        crewMemberServiceImpl.save(crewMember2);
//
        LocalDateTime dateDeparture = LocalDateTime.of(2025, 3, 15, 14, 30);
        LocalDateTime dateArrived = LocalDateTime.of(2025, 3, 19, 14, 30);
//        List<CrewMemberDTO> crewList = new ArrayList<>();
//        crewList.add(crewMember2);
//
////        flightServiceImpl.addCrewMemberDTO(flight3, crewList);
//        flightServiceImpl.save(flight3);
////
        LocalDateTime currentDate = LocalDateTime.now();

////        TypeMaintenance typeMaintenance1 = new TypeMaintenance("Alas", 100.0);
////        TypeMaintenance typeMaintenance2 = new TypeMaintenance("llantas", 200.0);
////        typeMaintenanceServiceImpl.save(typeMaintenance1);
////        typeMaintenanceServiceImpl.save(typeMaintenance2);
////
////        Maintenance maintenance1 = new Maintenance(currentDate, 100.0);
////        Maintenance maintenance2 = new Maintenance(currentDate, 200.0);
////  

PlaneDTO plane1 = new PlaneDTO("2023", 100, "acemario");
planeServiceImpl.save(plane1);
PlaneDTO plane2 = new PlaneDTO("2023", 100, "mario");
planeServiceImpl.save(plane2);
        AirportDTO airport1 = new AirportDTO("ave maria", "Cucuta");
        AirportDTO airport2 = new AirportDTO("ave mario", "barranca");
        airportServiceImpl.save(airport1);
        airportServiceImpl.save(airport2);
        
        List<String> crew = new ArrayList<>();
        
        crew.add(crewMember1.getIDMember());
        crew.add(crewMember2.getIDMember());
        
                FlightDTO flight3 = new FlightDTO(
                        dateDeparture,
                        dateArrived,
                        airport1.getName(),
                        airport1.getName(),
                        plane1.getName(),
                        crew
                        );
                
                
                System.out.println(flight3.getDestination());
                flightServiceImpl.save(flight3);

        
        ClassSeatDTO classSeat1 = new ClassSeatDTO(100, "VIP");
        classSeatServiceImpl.save(classSeat1);
        
        PassengerDTO passenger1 = new PassengerDTO("juan", "12345678");
        passengerServiceImpl.save(passenger1);
////
////        Place place1 = new Place("tijuacana", airport1);
////        Place place2 = new Place("madrid", airport2);
////
////
////        Maintenance maintenance3 = new Maintenance(currentDate, 700.0, plane1);
////
////        ClassSeat classSeat1 = new ClassSeat(500, "VIP");
////        ClassSeat classSeat2 = new ClassSeat(100, "1");
//
//        Flight flight1 = new Flight(dateDeparture, dateArrived);
//
//
////        Passenger passenger1 = new Passenger("123", "Marcus");
////        
////        LocalDateTime currentDateTime = LocalDateTime.now();
////
////

////        Ticket ticket2 = new Ticket(currentDateTime, currentDateTime, "A3");
////
////        airport1.setPlace(place1);
////        airport2.setPlace(place2);
////


////        List<TypeMaintenance> typesMaintenenceMaintenence1 = new ArrayList<>();
////        typesMaintenenceMaintenence1.add(typeMaintenance1);
////        typesMaintenenceMaintenence1.add(typeMaintenance2);
//
////        List<TypeMaintenance> typesMaintenenceMaintenence2 = new ArrayList<>();
////        typesMaintenenceMaintenence2.add(typeMaintenance1);
////
////        maintenanceServiceImpl.addTypeMaintenance(maintenance1, typesMaintenenceMaintenence1);
////        maintenanceServiceImpl.addTypeMaintenance(maintenance2, typesMaintenenceMaintenence2);
////
//////        --- OneToOne Manintenance with plane ---
////        plane1.setMaintenance(maintenance3);
////        planeServiceImpl.save(plane1);
//
////        flight3.setPlane(plane1);
////                        flightServiceImpl.save(flight3);
//
//
//
////        List<TypeMaintenance> typesMaintenenceMaintenence3 = new ArrayList<>();
////        typesMaintenenceMaintenence3.add(typeMaintenance1);
////        maintenanceServiceImpl.addTypeMaintenance(maintenance3, typesMaintenenceMaintenence3);
//  
////        --- OneToMany passenger with ticket ---
////        classSeatServiceImpl.save(classSeat1);
////        flightServiceImpl.save(flight1);
        PayMethod payMethod1 = new PayMethod("Nqui");
        payMethodServiceImpl.save(payMethod1);
        PayMethod payMethod2 = new PayMethod("Nqui1");
        payMethodServiceImpl.save(payMethod2);
////        passengerServiceImpl.save(passenger1);

flight3.setId(Long.MIN_VALUE);
////
        TicketDTO ticket1 = new TicketDTO(
                dateDeparture,
                dateArrived, 
                "A1", 
                Long.valueOf(1),
                classSeat1.getSeatClass(),
                passenger1.getIDPassenger(),
                payMethod1.getName());
        
        System.out.println(ticket1);
//        
        ticketServiceImpl.save(ticket1);
        
        TypeMaintenanceDTO typeMaintenanceDTO = new TypeMaintenanceDTO("Alas", 12.1);
        typeMaintenanceServiceImpl.save(typeMaintenanceDTO);
        
        LocalDate local = LocalDate.now();
        
        List<String> Types = new ArrayList<>();
        
        Types.add(typeMaintenanceDTO.getName());
        
        MaintenanceDTO maintenanceDTO = new MaintenanceDTO(
                local, 
                Double.NaN,
                plane1.getName(),
                Types
        );
        
        maintenanceServiceImpl.save(maintenanceDTO);
        
        UserDTO userDTO = new UserDTO("fdfdff", "jose@gamuk");
        
        useServiceImpl.save(userDTO);
        
        EndPointServiceImpl endPointServiceImpl = context.getBean(EndPointServiceImpl.class);
        EndPoint endPoint1 = new EndPoint("/airports", "airports");
        endPointServiceImpl.saveEndPoint(endPoint1);

        EndPoint endPoint2 = new EndPoint("/classseats", "classes seats");
        endPointServiceImpl.saveEndPoint(endPoint2);
        EndPoint endPoint3 = new EndPoint("/flights", "flights");
        endPointServiceImpl.saveEndPoint(endPoint3);
        EndPoint endPoint4 = new EndPoint("/tickets", "tickets");
        endPointServiceImpl.saveEndPoint(endPoint4);
        EndPoint endPoint5 = new EndPoint("/crewmembers", "crew members");
        endPointServiceImpl.saveEndPoint(endPoint5);

        EndPoint endPoint6 = new EndPoint("/maintenances", "maintenances");
        endPointServiceImpl.saveEndPoint(endPoint6);
        EndPoint endPoint7 = new EndPoint("/passengers", "passengers");
        endPointServiceImpl.saveEndPoint(endPoint7);
        EndPoint endPoint8 = new EndPoint("/paymethods", "pay methods");
        endPointServiceImpl.saveEndPoint(endPoint8);
        EndPoint endPoint9 = new EndPoint("/places", "places");
        endPointServiceImpl.saveEndPoint(endPoint9);

        EndPoint endPoint10 = new EndPoint("/planes", "planes");
        endPointServiceImpl.saveEndPoint(endPoint10);
        EndPoint endPoint11 = new EndPoint("/roles", "roles");
        endPointServiceImpl.saveEndPoint(endPoint11);
        EndPoint endPoint12 = new EndPoint("/typesmaintenances", "types maintenances");
        endPointServiceImpl.saveEndPoint(endPoint12);
    }

}
