package managementsystem.edenclinic.demo.controllers;

import managementsystem.edenclinic.demo.models.*;
import managementsystem.edenclinic.demo.security.CurrentUser;
import managementsystem.edenclinic.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Controller
public class BookingController {
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

    @Autowired
    BookingsService bookingsService;

    @Autowired
    CurrentUser currentUser;

    @GetMapping("/bookings")
    public String getAllBookings(Model model){
        List<Booking> bookings = bookingsService.getAllBookings();
        model.addAttribute("allBookings", bookings);
        return "/bookings";
    }

    @GetMapping("/book/time/{timeAvailableId}")
    public String bookDoctorWithTimeAvailable(@PathVariable("timeAvailableId") long timeAvailableId){
        Booking booking = new Booking();
        Optional<TimeAvailable> optionalTimeAvailable = timeAvailableService.getTimeAvailableById(timeAvailableId);
        TimeAvailable timeAvailable = null;
        if(optionalTimeAvailable.isPresent()){
            timeAvailable = optionalTimeAvailable.get();
        }else{
            return "/doctors";
        }
        booking.setTimeAvailable(timeAvailable);

        User user = currentUser.getLoggedInUser();

        booking.setUser(user);

        bookingsService.saveBooking(booking);

        return "redirect:/bookings";
    }

    @GetMapping("/book/doctor/{doctorId}")
    public String bookDoctor(@PathVariable("doctorId") long doctorId){
        Optional<Doctor> optionalDoctor = doctorService.getDoctorById(doctorId);
        Doctor doctor = null;
        if (optionalDoctor.isPresent()){
            doctor = optionalDoctor.get();
        }else{
            return "redirect:/doctors";
        }

        Set<TimeAvailable> timeAvailables =  doctor.getTimeAvailables();

        if(timeAvailables.isEmpty()){
            return "redirect:/doctors";
        }

        Booking booking = new Booking();

        int size = timeAvailables.size();
        int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
        int i = 0;
        TimeAvailable timeAvailable = null;
        for(TimeAvailable RtimeAvailable : timeAvailables)
        {
            if (i == item)
                timeAvailable = RtimeAvailable;
            i++;
        }

        booking.setTimeAvailable(timeAvailable);

        User user = currentUser.getLoggedInUser();

        booking.setUser(user);

        bookingsService.saveBooking(booking);

        return "redirect:/bookings";
    }

    @GetMapping("/book/department/{departmentid}")
    public String bookDoctorByDepartment(@PathVariable("departmentid") long departmentid){
        Optional<Department> optionalDepartment = departmentService.getDepartmentById(departmentid);
        Department department = null;
        if (optionalDepartment.isPresent()){
            department = optionalDepartment.get();
        }else{
            return "redirect:/doctors";
        }

        Set<Doctor> doctors = department.getDoctors();

        int size = doctors.size();
        int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
        int i = 0;
        Doctor doctor = null;
        for(Doctor rDoctor : doctors)
        {
            if (i == item)
                doctor = rDoctor;
            i++;
        }


        Set<TimeAvailable> timeAvailables =  doctor.getTimeAvailables();

        if(timeAvailables.isEmpty()){
            return "redirect:/doctors";
        }

        Booking booking = new Booking();

        int size1 = timeAvailables.size();
        int item1 = new Random().nextInt(size1); // In real life, the Random object should be rather more shared than this
        int j = 0;
        TimeAvailable timeAvailable = null;
        for(TimeAvailable RtimeAvailable : timeAvailables)
        {
            if (j == item1)
                timeAvailable = RtimeAvailable;
            i++;
        }

        booking.setTimeAvailable(timeAvailable);

        User user = currentUser.getLoggedInUser();

        booking.setUser(user);

        bookingsService.saveBooking(booking);

        return "redirect:/bookings";
    }
}
