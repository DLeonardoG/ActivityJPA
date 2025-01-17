
package com.campus.activityjpa.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Passanger {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idPassanger;
    private String name;
    private int ID;
    
}
