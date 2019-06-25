package Ordermanager.Testing.utils;

import Ordermanager.Testing.entities.User;
import Ordermanager.Testing.repository.UserRepository;
import Ordermanager.Testing.service.UserServiceImp1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class Helper {
    private final UserServiceImp1 userService;

    public Helper(UserServiceImp1 userService) {
        this.userService = userService;
    }

    @Autowired
    private UserRepository userRepo;

    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        UserDetails userDetails = (UserDetails)  authentication.getPrincipal();
        return userService.findUserByEmail(userDetails.getUsername());
    }

    public String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
