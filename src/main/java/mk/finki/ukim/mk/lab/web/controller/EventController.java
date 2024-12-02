package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.Jpa.CategoryRepository;
import mk.finki.ukim.mk.lab.service.CategoryService;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping({"/events", "/"})
public class EventController {

    private final EventService eventService;
    private final LocationService locationService;
    private final CategoryService categoryService;

    public EventController(EventService eventService, LocationService locationService, CategoryService categoryService) {
        this.eventService = eventService;
        this.locationService = locationService;
        this.categoryService = categoryService;
    }
    @GetMapping()
    public String getEventsPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("bodyContent", "events");
        model.addAttribute("events", this.eventService.listAll());
        return "listEvents";
    }

    @GetMapping("/add-form")
    public String getAddEventPage(Model model) {
        List<Location> locations = this.locationService.findAll();
        List<Event> events = this.eventService.listAll();
        List<Category> categories = this.categoryService.listAll();
        model.addAttribute("locations", locations);
        model.addAttribute("events", events);
        model.addAttribute("categories", categories);
        return "add-event";
    }

    @GetMapping("/add-category")
    public String getAddCategoryPage(Model model) {
        List<Location> locations = this.locationService.findAll();
        List<Event> events = this.eventService.listAll();
        List<Category> categories = this.categoryService.listAll();
        model.addAttribute("locations", locations);
        model.addAttribute("events", events);
        model.addAttribute("categories", categories);
        return "add-category";
    }


    @PostMapping("/add")
    public String saveEvent(@RequestParam String name,
                            @RequestParam String description,
                            @RequestParam Double popularityScore ,
                            @RequestParam Long location,
                            @RequestParam Long category){
        this.eventService.save(name, description, popularityScore, location, category);
        return "redirect:/events";
    }

    @PostMapping("/addCategory")
    public String saveEvent(@RequestParam String name){
        this.categoryService.save(name);
        return "redirect:/events";
    }

    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id){
        this.eventService.deleteById(id);
        return "redirect:/";
    }
    @PostMapping("/like/{id}")
    public String likeEvent(@PathVariable Long id){
        this.eventService.likeById(id);
        return "redirect:/events";
    }

    @GetMapping("/edit/{eventId}")
    public String editEvent(@PathVariable Long eventId, Model model) {
        if (this.eventService.findById(eventId).isPresent()) {
            Event event = this.eventService.findById(eventId).get();
            List<Location> locations = this.locationService.findAll();
            model.addAttribute("locations", locations);
            model.addAttribute("event", event);
            return "add-event";
        }
        return "redirect:/products?error=ProductNotFound";
    }

}
