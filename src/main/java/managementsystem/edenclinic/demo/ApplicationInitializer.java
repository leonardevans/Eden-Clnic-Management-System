package managementsystem.edenclinic.demo;

import managementsystem.edenclinic.demo.models.Role;
import managementsystem.edenclinic.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements CommandLineRunner {
    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        Role userRole = roleService.getRoleByName("ROLE_USER");
        if(userRole == null){
            roleService.saveRole(new Role("ROLE_USER"));
        }

        Role doctorRole = roleService.getRoleByName("ROLE_DOCTOR");
        if(doctorRole == null){
            roleService.saveRole(new Role("ROLE_DOCTOR"));
        }

        Role managerRole = roleService.getRoleByName("ROLE_MANAGER");
        if(managerRole == null){
            roleService.saveRole(new Role("ROLE_MANAGER"));
        }
    }
}
