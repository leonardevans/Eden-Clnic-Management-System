package managementsystem.edenclinic.demo.services;

import managementsystem.edenclinic.demo.models.TimeAvailable;

import java.util.List;
import java.util.Optional;

public interface TimeAvailableService {
    List<TimeAvailable> getDoctorTimeAvailable(long id);
    void saveTimeAvailable(TimeAvailable timeAvailable);
    Optional<TimeAvailable> getTimeAvailableById(long id);
    
}
