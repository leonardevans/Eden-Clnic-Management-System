package managementsystem.edenclinic.demo.services;

import managementsystem.edenclinic.demo.models.Doctor;
import managementsystem.edenclinic.demo.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public Optional<Doctor> getDoctorById(long id) {
        return doctorRepository.findById(id);
    }
}
