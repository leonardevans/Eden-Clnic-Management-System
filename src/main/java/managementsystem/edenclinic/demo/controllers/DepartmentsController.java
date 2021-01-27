package managementsystem.edenclinic.demo.controllers;

import managementsystem.edenclinic.demo.models.Department;
import managementsystem.edenclinic.demo.payload.AddDepartmentRequest;
import managementsystem.edenclinic.demo.payload.SignUpRequest;
import managementsystem.edenclinic.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class DepartmentsController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping({"/departments", "/departments/index"})
    public String showDepartments(Model model){
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("addDepartmentRequest", new AddDepartmentRequest());
        model.addAttribute("allDepartments", departments);
        return "/departments/index";
    }

    @PostMapping("/departments/add")
    public String addDepartment(@ModelAttribute("addDepartmentRequest") AddDepartmentRequest addDepartmentRequest, BindingResult bindingResult){
        Department department = new Department(addDepartmentRequest.getDepartmentName());
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping({"/department/{id}"})
    public String showDepartment(@PathVariable long id, Model model){
        Optional<Department> optionalDepartment = departmentService.getDepartmentById(id);
        Department department = null;
        if (optionalDepartment.isPresent()){
            department = optionalDepartment.get();
        }else{
            return "/departments/index";
        }


        model.addAttribute("department" , department);
        return "/departments/department";
    }
}
