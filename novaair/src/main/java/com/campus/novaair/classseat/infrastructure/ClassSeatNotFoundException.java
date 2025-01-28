/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.classseat.infrastructure;

/**
 *
 * @author kevin
 */
public class ClassSeatNotFoundException extends RuntimeException{
    public ClassSeatNotFoundException(String message) {
        super(message);
    }
}
