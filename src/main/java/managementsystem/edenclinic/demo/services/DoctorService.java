package managementsystem.edenclinic.demo.services;

import managementsystem.edenclinic.demo.models.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    void saveDoctor(Doctor doctor );
    Optional<Doctor> getDoctorById(long id);
}
