package mk.finki.ukim.mk.lab.repository.inMemory;

import mk.finki.ukim.mk.lab.model.Users;
import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Repository
public class InMemoryUserRepository {
    public Optional<Users> findByUsername(String username) {
        return DataHolder.users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    public Optional<Users> findByUsernameAndPassword(String username, String password) {
        return DataHolder.users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();
    }

    public Users saveOrUpdate(Users user) {
        DataHolder.users.removeIf(existingUser -> existingUser.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        return user;
    }

    public void deleteByUsername(String username) {
        DataHolder.users.removeIf(user -> user.getUsername().equals(username));
    }

    public Collection<Object> findAll() {
        return Collections.singleton(DataHolder.users);
    }
}


