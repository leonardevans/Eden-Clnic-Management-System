package managementsystem.edenclinic.demo.services;

import managementsystem.edenclinic.demo.models.Booking;
import managementsystem.edenclinic.demo.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingsService{
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> getBookingById(long id) {
        return bookingRepository.findById(id);
    }
}
