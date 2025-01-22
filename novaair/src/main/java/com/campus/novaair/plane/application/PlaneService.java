/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.campus.novaair.plane.application;

import com.campus.novaair.plane.domain.Plane;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface PlaneService {
    List<Plane> getAllRoles();

    Plane getRoleById(Long id);

    Plane saveRole(Plane plane);

    void deleteRole(Long id);
}
