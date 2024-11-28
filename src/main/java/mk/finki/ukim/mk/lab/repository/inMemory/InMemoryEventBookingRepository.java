package mk.finki.ukim.mk.lab.repository.inMemory;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryEventBookingRepository {

    public EventBooking save(EventBooking booking) {
        DataHolder.bookings.removeIf(e -> e.getEventName().equals(booking.getEventName()));
        DataHolder.bookings.add(booking);
        return booking;
    }

    public List<EventBooking> findAll() {
        return DataHolder.bookings;
    }

    public List<EventBooking> searchEvents(String text){
        return DataHolder.bookings.stream()
                .filter(e -> e.getEventName().contains(text) ||
                        e.getAttendeeName().contains(text) ||
                        e.getAttendeeAddress().contains(text))
                .toList();
    }
}
