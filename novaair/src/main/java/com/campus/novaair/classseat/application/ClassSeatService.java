package com.campus.novaair.classseat.application;

import com.campus.novaair.role.domain.Role;
import java.util.List;


public interface ClassSeatService {
   List<Role> getAllRoles();
   Role getRoleById(Long id);
   Role saveRole(Role role);
   void deleteRole(Long id);
}
