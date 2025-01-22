
package com.campus.novaair.role.domain;


import java.util.List;
import java.util.Optional;

public interface RoleRepository{
    List<Role> findAll();
    Role save(Role role);
     Optional<Role> findById(Long id);
    void deleteById(Long id);
}
