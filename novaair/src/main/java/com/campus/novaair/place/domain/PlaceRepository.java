/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.novaair.place.domain;

import java.util.List;

/**
 *
 * @author kevin
 */
public interface PlaceRepository {
    List<Place> findAll();
    Place save(Place place);
}
