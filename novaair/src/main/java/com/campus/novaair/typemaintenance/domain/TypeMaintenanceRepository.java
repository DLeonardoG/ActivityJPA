
package com.campus.novaair.typemaintenance.domain;


import java.util.List;
import java.util.Optional;

public interface TypeMaintenanceRepository {
    List<TypeMaintenance> findAll();
    TypeMaintenance save(TypeMaintenance typeMaintenance);
    Optional<TypeMaintenance> findById(Long id);
    void deleteById(Long id);
}
