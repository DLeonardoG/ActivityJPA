
package com.campus.novaair.airport.infrastructure;

public class AirportNotFoundException extends RuntimeException{
    public AirportNotFoundException(String message) {
        super(message);
    }
}
