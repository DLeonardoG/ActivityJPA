/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.activityjpa.model.repository;

import com.campus.activityjpa.model.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kevin
 */
public interface PlaneRepository extends JpaRepository<Plane, Long>{
    
}
