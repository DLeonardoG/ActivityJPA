
package com.campus.novaair.plane.application;

import com.campus.novaair.plane.domain.Plane;
import java.util.List;

public interface PlaneService {
    List<Plane> getAllRoles();

    Plane getRoleById(Long id);

    Plane saveRole(Plane plane);

    void deleteRole(Long id);
}
