/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.place.infrastructure;

/**
 *
 * @author kevin
 */
public class PlaceNotFoundException extends RuntimeException{
    public PlaceNotFoundException(String message) {
        super(message);
    }
}
