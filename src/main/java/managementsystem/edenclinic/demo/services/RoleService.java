package managementsystem.edenclinic.demo.services;

import managementsystem.edenclinic.demo.models.Role;

public interface RoleService {
    void saveRole(Role role);
    Role getRoleByName(String name);
}
