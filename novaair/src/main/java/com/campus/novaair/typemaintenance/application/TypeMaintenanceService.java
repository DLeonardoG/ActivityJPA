/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.novaair.typemaintenance.application;

import com.campus.novaair.typemaintenance.domain.TypeMaintenance;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface TypeMaintenanceService {

    List<TypeMaintenance> getAllTypeMaintenance();

    TypeMaintenance getTypeMaintenanceById(Long id);

    TypeMaintenance saveTypeMaintenance(TypeMaintenance typeMaintenance);

    void deleteTypeMaintenance(Long id);
}
