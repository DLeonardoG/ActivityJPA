
package com.campus.novaair.role.application;

import com.campus.novaair.role.domain.Role;
import java.util.List;

public interface RoleService {
   List<Role> getAllRoles();
   Role getRoleById(Long id);
   Role saveRole(Role role);
   void deleteRole(Long id);
    
}
