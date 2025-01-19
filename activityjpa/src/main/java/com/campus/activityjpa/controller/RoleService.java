/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campus.activityjpa.controller;

import com.campus.activityjpa.model.entity.CrewMember;
import com.campus.activityjpa.model.entity.Role;
import com.campus.activityjpa.model.repository.RoleRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(String name) {
        Role role = new Role(name);
        return roleRepository.save(role);
    }
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
    
    @Transactional
    public Role saveRoleWithCrewMembers(String roleName, Map<String, String> crewMembers){
        Role role = new Role(roleName);
        List<CrewMember> crewList = crewMembers.entrySet()
            .stream()
            .map(entry -> new CrewMember(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());
        
        for (CrewMember member : crewList) {
            role.addCrewMembers(member);
        }
        return roleRepository.save(role);
    }
}