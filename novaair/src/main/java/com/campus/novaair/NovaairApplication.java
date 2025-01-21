package com.campus.novaair;

import com.campus.novaair.airport.application.AirportServiceImpl;
import com.campus.novaair.airport.domain.Airport;
import com.campus.novaair.classseat.application.ClassSeatServiceImpl;
import com.campus.novaair.classseat.domain.ClassSeat;
import com.campus.novaair.crewmember.application.CrewMemberServiceImpl;
import com.campus.novaair.crewmember.domain.CrewMember;
import com.campus.novaair.fligh.domain.FlightServiceImpl;
import com.campus.novaair.flight.application.Flight;
import com.campus.novaair.maintenances.application.MaintenanceServicesImpl;
import com.campus.novaair.maintenances.domain.Maintenance;
import com.campus.novaair.passangers.application.PassengerServiceImpl;
import com.campus.novaair.passangers.domain.Passenger;
import com.campus.novaair.paymethod.application.PayMethodServiceImpl;
import com.campus.novaair.paymethod.domain.PayMethod;
import com.campus.novaair.role.application.RoleServiceImpl;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.management.relation.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NovaairApplication {
    
    public static void main(String[] args) {
        
        ConfigurableApplicationContext context = SpringApplication.run(NovaairApplication.class, args);
        
        RoleServiceImpl roleServiceImpl = context.getBean(RoleServiceImpl.class);
        Role role = new 

        PayMethodServiceImpl payMtehodServiceImpl = context.getBean(PayMethodServiceImpl.class);
        PayMethod payMethod = new PayMethod("efectivo");
        payMtehodServiceImpl.savePayMethod(payMethod);

        AirportServiceImpl airportServiceImpl = context.getBean(AirportServiceImpl.class);
        Airport airport = new Airport("eyeye");
        airportServiceImpl.saveAirport(airport);
        
        ClassSeatServiceImpl classSeatServiceImpl = context.getBean(ClassSeatServiceImpl.class);
        ClassSeat classSeat = new ClassSeat(1000, "primera class");
        classSeatServiceImpl.saveClassSeat(classSeat);
        
        
        CrewMemberServiceImpl crewMemberServiceImpl = context.getBean(CrewMemberServiceImpl.class);
        CrewMember crewMember = new CrewMember("1097782030", "sassant");
        crewMemberServiceImpl.saveCrewMember(crewMember);
        
        FlightServiceImpl flightServiceImpl = context.getBean(FlightServiceImpl.class);
        LocalDateTime departure = LocalDateTime.of(2025, 1, 22, 10, 30); // Fecha de salida
        LocalDateTime arrival = LocalDateTime.of(2025, 1, 22, 14, 45);   // Fecha de llegada
        Flight flight = new Flight(departure, arrival);
        flightServiceImpl.saveFlight(flight);
        
        MaintenanceServicesImpl maintenanceServicesImpl = context.getBean(MaintenanceServicesImpl.class);
        LocalDate maintenanceDate = LocalDate.of(2025, 1, 22);
        Maintenance maintenance = new Maintenance(maintenanceDate, 100.50);
        maintenanceServicesImpl.saveMaintenance(maintenance);


        PassengerServiceImpl passengerServiceImpl= context.getBean(PassengerServiceImpl.class);
        Passenger passenger = new Passenger("12345", "fredi khalo");
        passengerServiceImpl.saveRole(passenger);

    }
    
}
