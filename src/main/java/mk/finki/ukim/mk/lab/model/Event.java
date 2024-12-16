package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
//@Table(name = "event")
public class Event{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    double popularityScore;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Event(String name, String description, double popularityScore, Location location, Category category) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
        this.category = category;
    }
}
