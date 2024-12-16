package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Users;

public interface AuthService {

    Users login(String username, String password);

}


