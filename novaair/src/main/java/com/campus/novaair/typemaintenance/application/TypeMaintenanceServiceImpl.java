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
public class TypeMaintenanceServiceImpl implements TypeMaintenanceRepository{
    private final TypeMaintenanceRepository typeMaintenanceRepository;
    
    public TypeMaintenanceServiceImpl (TypeMaintenanceRepository typeMaintenanceRepository){
        this.typeMaintenanceRepository = typeMaintenanceRepository;
    }
    
    @Override
    public List<TypeMaintenance> findAll() {
        return typeMaintenanceRepository.findAll();
    }

    @Override
    public TypeMaintenance save(TypeMaintenance typeMaintenance) {
        return typeMaintenanceRepository.save(typeMaintenance);

    }

    @Override
    public Optional findById(Long id) {
        return typeMaintenanceRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        typeMaintenanceRepository.deleteById(id);
    }
    
}
