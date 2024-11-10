package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


// In-memory data holder
@Component
public class DataHolder {
    public static List<Event> events = null;
    public static List<EventBooking> bookings = null;

    @PostConstruct
    private void init() {
        events = new ArrayList<Event>();
        events.add(new Event("Masks on", "Mask party", 7.5));
        events.add(new Event("24", "Birthday party", 6.5));
        events.add(new Event("Kids lunch", "Charity event", 9.5));
        events.add(new Event("Mask 'n' ball", "Mask party", 8.0));
        events.add(new Event("D-fest", "Festival", 8.8));
        events.add(new Event("Taksirat", "Festival", 4.3));
        events.add(new Event("Parkce", "Coffee get-together", 9.8));
        events.add(new Event("Strumica Open", "Festival", 5.4));
        events.add(new Event("Pastarmalijada", "Festival", 8.2));
        events.add(new Event("Toshe Proevski", "Concert", 10.0));

        bookings = new ArrayList<>();
        bookings.add(new EventBooking("Masks on" , "Makedonka Vasileva", "Primer", 2));
        bookings.add(new EventBooking("Pastarmalijada" , "Makedonka Vasileva", "Primer", 2));
        bookings.add(new EventBooking("Taksirat" , "Makedonka Vasileva", "Primer", 3));
        bookings.add(new EventBooking("Parkce" , "Makedonka Vasileva", "Primer", 5));
        bookings.add(new EventBooking("24" , "Makedonka Vasileva", "Primer", 5));
    }
}
