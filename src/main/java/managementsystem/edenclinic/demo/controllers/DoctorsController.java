package managementsystem.edenclinic.demo.controllers;

import managementsystem.edenclinic.demo.models.*;
import managementsystem.edenclinic.demo.payload.AddDoctorRequest;
import managementsystem.edenclinic.demo.payload.AddTimeAvailableRequest;
import managementsystem.edenclinic.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class DoctorsController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    TimeAvailableService timeAvailableService;

    @GetMapping({"/doctors"})
    public String showDoctors(Model model){
        List<Doctor> doctors = doctorService.getAllDoctors();
        List<User> users = userService.getAllUsers();
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("allDepartments", departments);
        model.addAttribute("allUsers", users);
        model.addAttribute("allDoctors", doctors);
        model.addAttribute("addDoctorRequest", new AddDoctorRequest());
        return "/doctors/index";
    }

    @PostMapping("/doctors/add")
    public String addDoctor(@ModelAttribute("addDoctorRequest") AddDoctorRequest addDoctorRequest){
        Optional<User> optionalUser = userService.getUserById(addDoctorRequest.getUserId());
        User user = null;
        if (optionalUser.isPresent()){
            user = optionalUser.get();
        }else{
            return "/doctors/index";
        }

        Role doctorRole = roleService.getRoleByName("ROLE_DOCTOR");
        user.getRoles().add(doctorRole);

        Optional<Department> optionalDepartment = departmentService.getDepartmentById(addDoctorRequest.getDepartmentId());
        Department department = null;
        if(optionalDepartment.isPresent()){
            department = optionalDepartment.get();
        }else{
            return "/doctors/index";
        }

        Doctor doctor = new Doctor(user);
        doctor.getDepartments().add(department);

        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }


    @GetMapping({"/doctors/{id}"})
    public String showDoctor(@PathVariable long id, Model model){
        Optional<Doctor> optionalDoctor = doctorService.getDoctorById(id);
        Doctor doctor = null;
        if (optionalDoctor.isPresent()){
            doctor = optionalDoctor.get();
        }else{
            return "redirect:/doctors";
        }

        model.addAttribute("doctor", doctor);
        model.addAttribute("addTimeAvailableRequest", new AddTimeAvailableRequest());

        return "/doctors/doctor";
    }

    @PostMapping("/doctor/addTimeAvailable")
    public String addTimeAvailable(@ModelAttribute()AddTimeAvailableRequest addTimeAvailableRequest){
        Optional<Doctor> optionalDoctor = doctorService.getDoctorById(addTimeAvailableRequest.getDoctorId());
        Doctor doctor = null;
        if(optionalDoctor.isPresent()){
            doctor = optionalDoctor.get();
        }else{
            return "/doctors/index";
        }

        TimeAvailable timeAvailable = new TimeAvailable(addTimeAvailableRequest.getTimeFrom(), addTimeAvailableRequest.getTimeTo(), addTimeAvailableRequest.getDate(), doctor);
        timeAvailableService.saveTimeAvailable(timeAvailable);
        return "redirect:/doctors/" + doctor.getId();

    }


}
