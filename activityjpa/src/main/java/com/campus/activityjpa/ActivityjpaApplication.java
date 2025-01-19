package com.campus.activityjpa;

import com.campus.activityjpa.controller.MaintenanceService;
import com.campus.activityjpa.controller.RoleService;
import com.campus.activityjpa.controller.TypeMaintenanceService;
import com.campus.activityjpa.model.entity.Maintenance;
import com.campus.activityjpa.model.entity.Role;
import com.campus.activityjpa.model.entity.TypeMaintenance;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
//        roleService.getAll().forEach(System.out::println);

//          --- Types y mainteneces ---
        TypeMaintenanceService typeMaintenanceService = context.getBean(TypeMaintenanceService.class);
        MaintenanceService maintenanceService = context.getBean(MaintenanceService.class);
        
        TypeMaintenance typeMaintenance1 = new TypeMaintenance("Alas", 100.0);
        TypeMaintenance typeMaintenance2 = new TypeMaintenance("llantas", 200.0);
        
        typeMaintenanceService.saveTypeMaintenance(typeMaintenance1);
        typeMaintenanceService.saveTypeMaintenance(typeMaintenance2);
        
        LocalDate currentDate = LocalDate.now();
        Maintenance maintenance1 = new Maintenance(currentDate, 100.0);
        Maintenance maintenance2 = new Maintenance(currentDate, 200.0);
        
        List<TypeMaintenance> typesMaintenenceMaintenence1 = new ArrayList<>();
        typesMaintenenceMaintenence1.add(typeMaintenance1);
        typesMaintenenceMaintenence1.add(typeMaintenance2);
        
        List<TypeMaintenance> typesMaintenenceMaintenence2 = new ArrayList<>();
        typesMaintenenceMaintenence2.add(typeMaintenance1);
        
        maintenanceService.addTypeMaintenance(maintenance1, typesMaintenenceMaintenence1);
        maintenanceService.addTypeMaintenance(maintenance2, typesMaintenenceMaintenence2);
        
    }

}
