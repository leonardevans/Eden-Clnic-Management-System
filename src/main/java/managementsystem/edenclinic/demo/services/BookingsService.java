package managementsystem.edenclinic.demo.services;

import managementsystem.edenclinic.demo.models.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingsService {
    List<Booking> getAllBookings();
    void saveBooking(Booking booking);
    Optional<Booking> getBookingById(long id);
}
