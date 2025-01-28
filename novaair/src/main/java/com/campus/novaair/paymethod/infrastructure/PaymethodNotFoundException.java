/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.paymethod.infrastructure;

/**
 *
 * @author kevin
 */
public class PaymethodNotFoundException extends RuntimeException{
    public PaymethodNotFoundException(String message) {
        super(message);
    }
}