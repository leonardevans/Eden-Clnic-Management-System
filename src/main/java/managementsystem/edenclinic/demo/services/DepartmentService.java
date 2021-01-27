package managementsystem.edenclinic.demo.services;

import managementsystem.edenclinic.demo.models.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> getAllDepartments();
    void saveDepartment(Department department);
    Optional<Department> getDepartmentById(long id);
}
