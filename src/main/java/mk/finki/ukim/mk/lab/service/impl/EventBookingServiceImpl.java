package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.repository.inMemory.InMemoryEventBookingRepository;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    private final InMemoryEventBookingRepository eventBookingRepository;

    public EventBookingServiceImpl(InMemoryEventBookingRepository eventBookingRepository) {
        this.eventBookingRepository = eventBookingRepository;
    }


    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        return this.eventBookingRepository.save(new EventBooking(eventName, attendeeName, attendeeAddress, numberOfTickets));
    }

    @Override
    public List<EventBooking> listAll() {
        return this.eventBookingRepository.findAll();
    }

    @Override
    public List<EventBooking> searchEvents(String text) {
        return this.eventBookingRepository.searchEvents(text);
    }
}
