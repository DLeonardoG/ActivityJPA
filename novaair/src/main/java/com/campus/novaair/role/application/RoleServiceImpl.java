package com.campus.novaair.role.application;

import com.campus.novaair.role.domain.Role;
import com.campus.novaair.role.domain.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl{
    
    private final RoleRepository roleRepository;
    
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    
    public List<Role> getAllRoles() {
       return roleRepository.findAll();
    }

//    @Override
//    public Role getRoleById(Long id) {
//        Optional<Role> optionalRole = roleRepository.findById(id);
//        return optionalRole.orElse(null);
//    }

    public Role saveRole(Role role) {
         return roleRepository.save(role);
    }
//
//    @Override
//    public void deleteRole(Long id) {
//        roleRepository.deleteById(id);
//
//    }
    
    
}
