package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.Jpa.CategoryRepository;
import mk.finki.ukim.mk.lab.repository.Jpa.EventRepository;
import mk.finki.ukim.mk.lab.repository.Jpa.LocationRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;
//    private final InMemoryEventRepository inMemoryEventRepository;
    private final CategoryRepository categoryRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository, CategoryRepository categoryRepository/*, InMemoryEventRepository inMemoryEventRepository*/) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
//        this.inMemoryEventRepository = inMemoryEventRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Event> listAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
//        return this.inMemoryEventRepository.searchEvents(text);
        return this.eventRepository.findAllByNameOrDescription(text, text);
    }

    @Override
    public Event save(String name, String description, double popularityScore, Long locationId, Long categoryId) {
        Location location = locationRepository.findById(locationId).orElse(null);
        Category category = categoryRepository.findById(categoryId).orElse(null);
        Event event = new Event(name, description, popularityScore, location, category);
        return this.eventRepository.save(event);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return this.eventRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        Event event = this.eventRepository.findById(id).orElse(null);
        this.eventRepository.delete(event);
    }

    @Override
    public Event likeById(Long id) {
        Event event = (Event) this.eventRepository.findById(id).orElse(null);
        event.setPopularityScore(event.getPopularityScore()+1);
        return this.eventRepository.save(event);
    }
}
