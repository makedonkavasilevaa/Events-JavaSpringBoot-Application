package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EventBooking {
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
