
package com.campus.novaair.role.infrastructure;

import com.campus.novaair.role.application.RoleServiceImpl;
import com.campus.novaair.role.domain.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    
     
    private final RoleServiceImpl roleServiceImpl;
    
    @Autowired
    public RoleController(RoleServiceImpl roleServiceImpl){
        this.roleServiceImpl = roleServiceImpl;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Role> getAllRoles(){
        return roleServiceImpl.findAll();
    }
    
    @PostMapping
    public Role createRole(@RequestBody Role role){
        return roleServiceImpl.save(role);
    }
    
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id){
        roleServiceImpl.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role role){
        role.setId(id);
        return roleServiceImpl.save(role);
    }
    
}
