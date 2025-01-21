
package com.campus.novaair.role.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository{
    List<Role> findAll();
    Role save(Role role);
}
