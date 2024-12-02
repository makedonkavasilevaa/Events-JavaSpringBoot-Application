package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.Jpa.CategoryRepository;
import mk.finki.ukim.mk.lab.repository.Jpa.EventBookingRepository;
import mk.finki.ukim.mk.lab.repository.Jpa.EventRepository;
import mk.finki.ukim.mk.lab.repository.Jpa.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


// In-memory data holder
@Component
public class DataHolder {

    private final LocationRepository locationRepository;
    private final EventRepository eventRepository;
//    private final EventBooking eventBooking;
    private final CategoryRepository categoryRepository;


    public static List<Event> events = null;
    public static List<EventBooking> bookings = null;
    public static List<Location> locations = null;
    public static List<Category> categories = null;
    private final EventBookingRepository eventBookingRepository;

    public DataHolder(LocationRepository locationRepository, EventRepository eventRepository, CategoryRepository categoryRepository, EventBookingRepository eventBookingRepository) {
        this.locationRepository = locationRepository;
        this.eventRepository = eventRepository;
        this.categoryRepository = categoryRepository;
        this.eventBookingRepository = eventBookingRepository;
    }

    @PostConstruct
    private void init() {

        locations = new ArrayList<>();
        locations.add(new Location("Lokacija 1", "Address 1" , "100", "Description 1"));
        locations.add(new Location("Lokacija 2", "Address 2" , "150", "Description 2"));
        locations.add(new Location("Lokacija 3", "Address 3" , "50", "Description 3"));
        locations.add(new Location("Lokacija 4", "Address 4" , "1000", "Description 4"));
        locations.add(new Location("Lokacija 5", "Address 5" , "60", "Description 5"));
        if (locationRepository.findAll().isEmpty()) {
            locationRepository.saveAll(locations);
        }

        categories =  new ArrayList<>();
        categories.add(new Category("Festival"));
        categories.add(new Category("Carneval"));
        categories.add(new Category("Charity"));
        categories.add(new Category("Get Together"));
        categories.add(new Category("Party"));

        if (categoryRepository.findAll().isEmpty()){
            categoryRepository.saveAll(categories);
        }

        events = new ArrayList<Event>();
        events.add(new Event("Masks on", "Mask party", 7.5, locations.get(0), categories.get(0)));
        events.add(new Event("24", "Birthday party", 6.5, locations.get(1), categories.get(1)));
        events.add(new Event("Kids lunch", "Charity event", 9.5, locations.get(2), categories.get(2)));
        events.add(new Event("Mask 'n' ball", "Mask party", 8.0, locations.get(4), categories.get(3)));
        events.add(new Event("D-fest", "Festival", 8.8, locations.get(3), categories.get(0)));
        events.add(new Event("Taksirat", "Festival", 4.3, locations.get(4), categories.get(1)));
        events.add(new Event("Parkce", "Coffee get-together", 9.8, locations.get(0) , categories.get(2)));
        events.add(new Event("Strumica Open", "Festival", 5.4, locations.get(1), categories.get(3)));
        events.add(new Event("Pastarmalijada", "Festival", 8.2, locations.get(2), categories.get(0)));
        events.add(new Event("Toshe Proevski", "Concert", 10.0, locations.get(3), categories.get(1)));

        if (eventRepository.findAll().isEmpty()) {
            eventRepository.saveAll(events);
        }

        bookings = new ArrayList<>();
        bookings.add(new EventBooking("Masks on" , "Makedonka Vasileva", "Primer", 2));
        bookings.add(new EventBooking("Pastarmalijada" , "Makedonka Vasileva", "Primer", 2));
        bookings.add(new EventBooking("Taksirat" , "Makedonka Vasileva", "Primer", 3));
        bookings.add(new EventBooking("Parkce" , "Makedonka Vasileva", "Primer", 5));
        bookings.add(new EventBooking("24" , "Makedonka Vasileva", "Primer", 5));
        if (eventBookingRepository.findAll().isEmpty()) {
            eventRepository.saveAll(events);
        }


    }
}
