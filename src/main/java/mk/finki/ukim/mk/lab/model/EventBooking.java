package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "event_booking")
public class EventBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String eventName;
    String attendeeName;
    String attendeeAddress;
    int numberOfTickets;

    public EventBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        this.eventName = eventName;
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
    }
}
