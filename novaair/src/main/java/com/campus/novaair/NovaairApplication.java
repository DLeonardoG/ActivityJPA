package com.campus.novaair;




import com.campus.novaair.paymethod.domain.PayMethod;
import com.campus.novaair.paymethod.application.PayMethodServiceImpl;
import com.campus.novaair.role.application.RoleServiceImpl;
import com.campus.novaair.role.domain.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NovaairApplication {
    
    public static void main(String[] args) {
        
        ConfigurableApplicationContext context = SpringApplication.run(NovaairApplication.class, args);
        
        RoleServiceImpl roleServiceImpl = context.getBean(RoleServiceImpl.class);

        Role role = new Role("role");
        roleServiceImpl.saveRole(role);
        System.out.println("Role saved successfully!");
        
        PayMethodServiceImpl payMtehodServiceImpl = context.getBean(PayMethodServiceImpl.class);
        PayMethod paymethod = new PayMethod("visa");
        
        payMtehodServiceImpl.save(paymethod);
        
    }
    
}
