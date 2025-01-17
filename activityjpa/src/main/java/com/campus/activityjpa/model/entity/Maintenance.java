
package com.campus.activityjpa.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Maintenance {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idMaintenance;
    private String date;
    private double cost;
    
    
    
    
    
    
    
}
