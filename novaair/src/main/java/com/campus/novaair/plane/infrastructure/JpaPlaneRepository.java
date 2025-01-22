/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.novaair.plane.infrastructure;

import com.campus.novaair.plane.domain.Plane;
import com.campus.novaair.plane.domain.PlaneRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kevin
 */
public interface JpaPlaneRepository extends JpaRepository<Plane, Long>, PlaneRepository{
    
}
