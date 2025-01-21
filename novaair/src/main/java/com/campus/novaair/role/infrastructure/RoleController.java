
package com.campus.novaair.role.infrastructure;

import com.campus.novaair.role.application.RoleServiceImpl;
import com.campus.novaair.role.domain.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    
     
    private final RoleServiceImpl roleServiceImpl;
    
    @Autowired
    public RoleController(RoleServiceImpl roleServiceImpl){
        this.roleServiceImpl = roleServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Role> getAllRoles(){
        return roleServiceImpl.getAllRoles();
    }
    
}
