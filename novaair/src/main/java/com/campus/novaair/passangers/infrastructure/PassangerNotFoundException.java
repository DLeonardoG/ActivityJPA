/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.passangers.infrastructure;

/**
 *
 * @author kevin
 */
public class PassangerNotFoundException extends RuntimeException{
    public PassangerNotFoundException(String message) {
        super(message);
    }
}
