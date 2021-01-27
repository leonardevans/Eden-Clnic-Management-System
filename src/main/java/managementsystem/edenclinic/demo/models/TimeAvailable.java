package managementsystem.edenclinic.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TimeAvailable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String timeFrom;
    private String timeTo;
    private String date;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Doctor doctor;

    @OneToMany(mappedBy = "timeAvailable")
    private Set<Booking> bookings = new HashSet<>();

    public TimeAvailable() {
    }

    public TimeAvailable(String timeFrom, String timeTo, String date, Doctor doctor) {
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.date = date;
        this.doctor = doctor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}
