package managementsystem.edenclinic.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(nullable = false, referencedColumnName = "id")
    private User user;

    @ManyToMany()
    @JoinTable(
            joinColumns = {@JoinColumn(referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")}
    )
    private Set<Department> departments = new HashSet<>();

    @OneToMany(mappedBy = "doctor")
    private Set<TimeAvailable> timeAvailables = new HashSet<>();

    public Doctor() {
    }

    public Doctor(User user) {
        this.user = user;
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

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<TimeAvailable> getTimeAvailables() {
        return timeAvailables;
    }

    public void setTimeAvailables(Set<TimeAvailable> timeAvailables) {
        this.timeAvailables = timeAvailables;
    }
}
