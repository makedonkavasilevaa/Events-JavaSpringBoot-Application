package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventBooking {
    String eventName;
    String attendeeName;
    String attendeeAddress;
    int numberOfTickets;
}
