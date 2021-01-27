package managementsystem.edenclinic.demo.services;

import managementsystem.edenclinic.demo.models.Role;
import managementsystem.edenclinic.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}
