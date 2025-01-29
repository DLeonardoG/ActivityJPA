/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair;

import com.campus.novaair.airport.infrastructure.AirportNotFoundException;
import com.campus.novaair.classseat.infrastructure.ClassSeatNotFoundException;
import com.campus.novaair.crewmember.infraestructure.CrewmembertNotFoundException;
import com.campus.novaair.flight.infrastructure.FlightNotFoundException;
import com.campus.novaair.maintenances.infrastructure.MaintenanceFlightNotFoundException;
import com.campus.novaair.passangers.infrastructure.PassangerNotFoundException;
import com.campus.novaair.paymethod.infrastructure.PaymethodNotFoundException;
import com.campus.novaair.place.infrastructure.PlaceNotFoundException;
import com.campus.novaair.plane.infrastructure.PlaneNotFoundException;
import com.campus.novaair.role.infrastructure.RoleNotFoundException;
import com.campus.novaair.ticket.infrastructure.TicketNotFoundException;
import com.campus.novaair.typemaintenance.infrastructure.TypeMaintenanceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AirportNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleAirportNotFoundException(AirportNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Airport not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClassSeatNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleClassSeatNotFoundException(ClassSeatNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Class seat not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CrewmembertNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleCrewmemberNotFoundException(CrewmembertNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Crewmember not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FlightNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleFlightNotFoundException(FlightNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Flight not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MaintenanceFlightNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleMaintenanceFlightNotFoundException(MaintenanceFlightNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Maintenance flight not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PassangerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePassengerNotFoundException(PassangerNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Passenger not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymethodNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePaymethodNotFoundException(PaymethodNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Pay method not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PlaceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePlaceNotFoundException(PlaceNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Place not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PlaneNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePlaneNotFoundException(PlaneNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Plane not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleRoleNotFoundException(RoleNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Role not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TicketNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleTicketNotFoundException(TicketNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Ticket not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TypeMaintenanceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleTypeMaintenanceNotFoundException(TypeMaintenanceNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Type maintenance not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleInvalidIdException(IllegalArgumentException ex) {
        ErrorResponses errorResponse = new ErrorResponses("ID inválido", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Error de validación", ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ErrorResponses errorResponse = new ErrorResponses("Data integrity violation", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleGlobalException(Exception ex) {
        ErrorResponses errorResponse = new ErrorResponses("Error en la aplicación", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
