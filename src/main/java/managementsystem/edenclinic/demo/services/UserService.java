package managementsystem.edenclinic.demo.services;

import managementsystem.edenclinic.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);
    Optional<User> getUserByEmail(String email);
    boolean existsByEmail(String email);
    List<User> getAllUsers();
    Optional<User> getUserById(long id);
}
