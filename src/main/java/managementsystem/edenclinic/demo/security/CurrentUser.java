package managementsystem.edenclinic.demo.security;

import managementsystem.edenclinic.demo.models.User;
import managementsystem.edenclinic.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrentUser {
    @Autowired
    private UserRepository userRepository;

    public User getLoggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ( authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        UserDetails loggedInUser;
        try {
            loggedInUser = (UserDetails) principal;
        }
        catch (Exception e){
            return null;
        }
        Optional<User> optionalUser = userRepository.findByEmail(loggedInUser.getUsername());
        return optionalUser.orElse(null);

    }
}
