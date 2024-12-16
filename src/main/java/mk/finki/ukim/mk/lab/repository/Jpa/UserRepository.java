package mk.finki.ukim.mk.lab.repository.Jpa;

import mk.finki.ukim.mk.lab.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    Optional<Users> findByUsername(String username);

    Optional<Users> findByUsernameAndPassword(String username, String password);
}

