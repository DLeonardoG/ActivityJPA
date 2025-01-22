/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.novaair.place.application;

import com.campus.novaair.place.domain.Place;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface PlaceService {

    List<Place> getAllPlace();

    Place getPlaceById(Long id);

    Place savePlace(Place place);

    void deletePlace(Long id);
}
