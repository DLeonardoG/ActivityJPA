/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.novaair.plane.domain;

import java.util.List;

/**
 *
 * @author kevin
 */
public interface PlaneRepository {
    List<Plane> findAll();
    Plane save(Plane plane);
}
