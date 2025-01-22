/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.novaair.typemaintenance.application;

import com.campus.novaair.typemaintenance.domain.TypeMaintenance;
import com.campus.novaair.typemaintenance.domain.TypeMaintenanceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevin
 */
@Service
public class TypeMaintenanceServiceImpl {
    private final TypeMaintenanceRepository typeMaintenanceRepository;
    
    public TypeMaintenanceServiceImpl (TypeMaintenanceRepository typeMaintenanceRepository){
        this.typeMaintenanceRepository = typeMaintenanceRepository;
    }
    
    public TypeMaintenance saveTypeMaintenance( TypeMaintenance typeMaintenance){
        return typeMaintenanceRepository.save(typeMaintenance);
    }
    
    public List<TypeMaintenance> getAllTypeMaintenance(){
        return typeMaintenanceRepository.findAll();
    }
    
//    public Optional<TypeMaintenance> findTypeMaintenance (Long id){
//        return typeMaintenanceRepository.findById(id);
//    }
//    
//    public void removeTypeMaintenance (Long id){
//        typeMaintenanceRepository.deleteById(id);
//    }
}
