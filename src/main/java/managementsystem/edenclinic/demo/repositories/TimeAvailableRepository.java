package managementsystem.edenclinic.demo.repositories;

import managementsystem.edenclinic.demo.models.Doctor;
import managementsystem.edenclinic.demo.models.TimeAvailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeAvailableRepository extends JpaRepository<TimeAvailable, Long> {
    List<TimeAvailable> findByDoctor(Doctor doctor);
}
