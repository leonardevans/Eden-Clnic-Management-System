package managementsystem.edenclinic.demo.models;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private TimeAvailable timeAvailable;

    public Booking() {
    }

    public Booking(User user, TimeAvailable timeAvailable) {
        this.user = user;
        this.timeAvailable = timeAvailable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TimeAvailable getTimeAvailable() {
        return timeAvailable;
    }

    public void setTimeAvailable(TimeAvailable timeAvailable) {
        this.timeAvailable = timeAvailable;
    }
}
