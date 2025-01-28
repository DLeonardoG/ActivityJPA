/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.maintenances.infrastructure;

/**
 *
 * @author kevin
 */
public class MaintenanceFlightNotFoundException extends RuntimeException{
    public MaintenanceFlightNotFoundException(String message) {
        super(message);
    }
}
