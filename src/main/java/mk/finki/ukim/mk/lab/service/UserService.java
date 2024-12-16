package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Users;
import mk.finki.ukim.mk.lab.model.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Users register(String username, String password, String repeatPassword, String name, String surname, Role role);
}

