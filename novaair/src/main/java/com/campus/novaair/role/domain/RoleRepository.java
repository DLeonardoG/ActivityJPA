
package com.campus.novaair.role.domain;

import java.util.List;

public interface RoleRepository{
    List<Role> findAll();
    Role save(Role role);
}
