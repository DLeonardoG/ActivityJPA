/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.plane.infrastructure;

/**
 *
 * @author kevin
 */
public class PlaneNotFoundException extends RuntimeException{
    public PlaneNotFoundException(String message) {
        super(message);
    }
}