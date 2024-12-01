package mk.finki.ukim.mk.lab.repository.Jpa;

import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventBookingRepository extends JpaRepository<EventBooking, Integer> {

    List<EventBooking> findEventBookingByAttendeeAddressOrAttendeeNameOrEventName(String attendeeAddress, String attendeeName, String eventName);
}
