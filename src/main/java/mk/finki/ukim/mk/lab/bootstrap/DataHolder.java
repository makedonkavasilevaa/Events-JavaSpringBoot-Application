package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


// In-memory data holder
@Component
public class DataHolder {
    public static List<Event> events = null;

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
    }
}
