package mr.buddies.projects.ScrutinyGlobal.services;

import mr.buddies.projects.ScrutinyGlobal.model.CustomUserDetails;
import mr.buddies.projects.ScrutinyGlobal.model.User;
import mr.buddies.projects.ScrutinyGlobal.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        final User user = this.userRepository.findByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User not found !!");
        } else {
            return new CustomUserDetails(user);
        }


        //user database `

//        if (userName.equals("Durgesh")) {
//            return new User("Durgesh", "Durgesh123", new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found !!");
//        }

    }
}
