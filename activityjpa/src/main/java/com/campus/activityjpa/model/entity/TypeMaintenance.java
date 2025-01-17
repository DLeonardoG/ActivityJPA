/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.activityjpa.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author camper
 */
@Entity
public class TypeMaintenance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeMantence;
    
    private String name;
    
    private int coste;

    public TypeMaintenance() {
    }

    public TypeMaintenance(Long idTypeMantence, String name, int coste) {
        this.idTypeMantence = idTypeMantence;
        this.name = name;
        this.coste = coste;
    }

    public Long getIdTypeMantence() {
        return idTypeMantence;
    }

    public void setIdTypeMantence(Long idTypeMantence) {
        this.idTypeMantence = idTypeMantence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    @Override
    public String toString() {
        return "TypeMaintenance{" + "idTypeMantence=" + idTypeMantence + ", name=" + name + ", coste=" + coste + '}';
    }
    
    
    
    
}
