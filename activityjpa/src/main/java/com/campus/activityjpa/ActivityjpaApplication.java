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

           
        Map<String, String> members = new HashMap<>();
        members.put("1", "camilo");
        members.put("2", "clros");
        members.put("1", "mafer");

        System.out.println(members);
        
        
        
         RoleService roleService = context.getBean(RoleService.class);
         roleService.saveRoleWithCrewMembers("piloto", members);
        
//            Role newRole = roleService.saveRole("qqqqqqqqqq");
//            System.out.println("h0  "+newRole);
    }

}
