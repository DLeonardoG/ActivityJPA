/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.novaair.place.infrastructure;

import com.campus.novaair.place.domain.Place;
import com.campus.novaair.place.domain.PlaceRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kevin
 */
public interface JpaPlaceRepository extends JpaRepository<Place, Long>, PlaceRepository{
    
}
