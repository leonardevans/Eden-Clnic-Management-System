package managementsystem.edenclinic.demo.repositories;

import managementsystem.edenclinic.demo.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
