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
import com.campus.novaair.maintenances.application.MaintenanceServicesImpl;
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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NovaairApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(NovaairApplication.class, args);

        RoleServiceImpl roleServiceImpl = context.getBean(RoleServiceImpl.class);
        Role role = new Role("pasajero");
        roleServiceImpl.save(role);

        PayMethodServiceImpl payMtehodServiceImpl = context.getBean(PayMethodServiceImpl.class);
        PayMethod payMethod = new PayMethod("efectivo");
        payMtehodServiceImpl.save(payMethod);
        
        AirportServiceImpl airportServiceImpl = context.getBean(AirportServiceImpl.class);
        Airport airport = new Airport("eyeye");
        airportServiceImpl.save(airport);
        Airport airport1 = new Airport("eyeye");
        airportServiceImpl.save(airport1);

        EndPointServiceImpl endPointServiceImpl = context.getBean(EndPointServiceImpl.class);
        EndPoint endPoint1 = new EndPoint("/airports", "airports");
        endPointServiceImpl.saveEndPoint(endPoint1);

        EndPoint endPoint2 = new EndPoint("/classseats", "classseats");
        endPointServiceImpl.saveEndPoint(endPoint2);
        EndPoint endPoint3 = new EndPoint("/flights", "flights");
        endPointServiceImpl.saveEndPoint(endPoint3);
        EndPoint endPoint4 = new EndPoint("/tickets", "tickets");
        endPointServiceImpl.saveEndPoint(endPoint4);
        EndPoint endPoint5 = new EndPoint("/crewmembers", "crewmembers");
        endPointServiceImpl.saveEndPoint(endPoint5);

        EndPoint endPoint6 = new EndPoint("/maintenances", "maintenances");
        endPointServiceImpl.saveEndPoint(endPoint6);
        EndPoint endPoint7 = new EndPoint("/passengers", "passengers");
        endPointServiceImpl.saveEndPoint(endPoint7);
        EndPoint endPoint8 = new EndPoint("/paymethods", "paymethods");
        endPointServiceImpl.saveEndPoint(endPoint8);
        EndPoint endPoint9 = new EndPoint("/places", "places");
        endPointServiceImpl.saveEndPoint(endPoint9);

        EndPoint endPoint10 = new EndPoint("/planes", "planes");
        endPointServiceImpl.saveEndPoint(endPoint10);
        EndPoint endPoint11 = new EndPoint("/roles", "roles");
        endPointServiceImpl.saveEndPoint(endPoint11);
        EndPoint endPoint12 = new EndPoint("/typesmaintenances", "typesmaintenances");
        endPointServiceImpl.saveEndPoint(endPoint12);

        ClassSeatServiceImpl classSeatServiceImpl = context.getBean(ClassSeatServiceImpl.class);
        ClassSeat classSeat = new ClassSeat(1000, "primera class");
        classSeatServiceImpl.save(classSeat);

        CrewMemberServiceImpl crewMemberServiceImpl = context.getBean(CrewMemberServiceImpl.class);
        CrewMember crewMember = new CrewMember("1097782030", "sassant");
        crewMemberServiceImpl.save(crewMember);

        FlightServiceImpl flightServiceImpl = context.getBean(FlightServiceImpl.class);
        LocalDateTime departure = LocalDateTime.of(2025, 1, 22, 10, 30); // Fecha de salida
        LocalDateTime arrival = LocalDateTime.of(2025, 1, 22, 14, 45);   // Fecha de llegada
        Flight flight = new Flight(departure, arrival);
        flightServiceImpl.save(flight);

        MaintenanceServicesImpl maintenanceServicesImpl = context.getBean(MaintenanceServicesImpl.class);
        LocalDate maintenanceDate = LocalDate.of(2025, 1, 22);
        Maintenance maintenance = new Maintenance(maintenanceDate, 100.50);
        maintenanceServicesImpl.save(maintenance);

        PassengerServiceImpl passengerServiceImpl = context.getBean(PassengerServiceImpl.class);
        Passenger passenger = new Passenger("12345", "fredi khalo");
        passengerServiceImpl.save(passenger);

        PlaceServiceImpl placeServiceImpl = context.getBean(PlaceServiceImpl.class);
        Place place = new Place("Medellin");
        placeServiceImpl.save(place);

        PlaneServiceImpl planeServiceImpl = context.getBean(PlaneServiceImpl.class);
        Plane plane = new Plane("B243543K", 80);
        planeServiceImpl.save(plane);
        
//        LocalDateTime currentDate = new LocalDateTime();
//
//          TicketServiceImpl ticketServiceImpl = context.getBean(TicketServiceImpl.class);
//          Ticket ticket = new Ticket(LocalDate.MAX, LocalDate.EPOCH, "12");
//          ticketServiceImpl.saveTicket(ticket);
        TypeMaintenanceServiceImpl typeMaintenanceServiceImpl = context.getBean(TypeMaintenanceServiceImpl.class);
        TypeMaintenance typeMaintenance = new TypeMaintenance("cambio elises", 800.000);
        typeMaintenanceServiceImpl.save(typeMaintenance);
    }

}
