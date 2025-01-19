package com.campus.activityjpa;

import com.campus.activityjpa.controller.RoleService;
import com.campus.activityjpa.model.entity.Role;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ActivityjpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ActivityjpaApplication.class, args);

//            --- Creation of a new role ---
//            RoleService roleService = context.getBean(RoleService.class);
//            Role newRole = roleService.saveRole(hostess"");
//            System.out.println("h0  "+newRole);
           
//        --- creation of a new crew member from role ---
//        Map<String, String> members = new HashMap<>();
//        members.put("1", "camilo");
//        members.put("2", "clros");
//        members.put("1", "mafer");
        
//        members.forEach((key, value) -> System.out.println("id: " + key + ", name: " + value));
//        roleService.saveRoleWithCrewMembers("pilot", members);
//        roleService.listOfRoles().forEach(System.out::println);
        


    }

}
