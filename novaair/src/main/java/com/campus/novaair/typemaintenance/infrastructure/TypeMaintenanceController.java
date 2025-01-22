/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.typemaintenance.infrastructure;

import com.campus.novaair.typemaintenance.application.TypeMaintenanceServiceImpl;
import com.campus.novaair.typemaintenance.domain.TypeMaintenance;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kevin
 */
@RestController
@RequestMapping("/api/typemaintenance")
public class TypeMaintenanceController {
    private final TypeMaintenanceServiceImpl typeMaintenanceServiceImpl;
    
    @Autowired
    public TypeMaintenanceController(TypeMaintenanceServiceImpl typeMaintenanceServiceImpl){
        this.typeMaintenanceServiceImpl = typeMaintenanceServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<TypeMaintenance> getAlltypeMaintenanceServiceImpl(){
        return typeMaintenanceServiceImpl.getAllTypeMaintenance();
    }
}
