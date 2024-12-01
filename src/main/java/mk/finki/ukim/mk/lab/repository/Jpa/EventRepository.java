package mk.finki.ukim.mk.lab.repository.Jpa;

import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    void deleteById(Long id);
    
    List<Event> findAllByLocation_Id(Long locationId);
    List<Event> findAllByNameOrDescription(String name, String description);

    Optional<Event> findById(Long id);
}
