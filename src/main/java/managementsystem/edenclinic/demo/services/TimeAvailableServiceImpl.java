package managementsystem.edenclinic.demo.services;

import managementsystem.edenclinic.demo.models.TimeAvailable;
import managementsystem.edenclinic.demo.repositories.TimeAvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeAvailableServiceImpl implements TimeAvailableService{
    @Autowired
    private TimeAvailableRepository timeAvailableRepository;

    @Override
    public List<TimeAvailable> getDoctorTimeAvailable(long id) {
        return timeAvailableRepository.findAll();
    }

    @Override
    public void saveTimeAvailable(TimeAvailable timeAvailable) {
        timeAvailableRepository.save(timeAvailable);
    }

    @Override
    public Optional<TimeAvailable> getTimeAvailableById(long id) {
        return timeAvailableRepository.findById(id);
    }
}
