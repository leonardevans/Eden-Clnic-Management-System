package managementsystem.edenclinic.demo.security;

import managementsystem.edenclinic.demo.models.User;
import managementsystem.edenclinic.demo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserServiceImpl userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = null;
        Optional<User> optionalUser = userService.getUserByEmail(email);
        if (optionalUser.isPresent()){
            user = optionalUser.get();
        }
        return UserPrincipal.build(user);
    }


}
