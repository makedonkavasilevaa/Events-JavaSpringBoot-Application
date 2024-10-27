package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository {

    public Event save(Event event) {
        DataHolder.events.removeIf( e -> e.getName().equals(event.getName()));
        DataHolder.events.add(event);
        return event;
    }

    public List<Event> findAll() {
        return DataHolder.events;
    }

    public List<Event> searchEvents(String text){
        return DataHolder.events.stream()
                .filter(e -> e.getName().contains(text) ||
                        e.getDescription().contains(text))
                .toList();
    }

}
