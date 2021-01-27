package managementsystem.edenclinic.demo.services;

import managementsystem.edenclinic.demo.models.Department;
import managementsystem.edenclinic.demo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Optional<Department> getDepartmentById(long id) {
        return departmentRepository.findById(id);
    }
}
