
package com.campus.novaair.role.infrastructure;

import com.campus.novaair.role.domain.Role;
import com.campus.novaair.role.domain.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRoleRepository  extends JpaRepository<Role, Long>, RoleRepository{
    
}
