package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "EventServlet", urlPatterns = {"/servlet/", ""})
public class EventListSevlet extends HttpServlet {
    private final EventService eventService;
    private final SpringTemplateEngine templateEngine;

    public EventListSevlet(EventService eventService, SpringTemplateEngine templateEngine) {
        this.eventService = eventService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("events", eventService.listAll());

        templateEngine.process("listEvents.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        String text = req.getParameter("text");
        double score = Double.parseDouble(req.getParameter("score"));

        List<Event> events = null;

        try {
            events = eventService.searchEvents(text);
            for (Event event : events) {
                if (event.getPopularityScore() <= score) {
                    events.remove(event);
                }
            }


        } catch (RuntimeException exception) {
            // If an exception is thrown, set the hasError variable to true and set the error message
            context.setVariable("hasError", true);
            context.setVariable("error", exception.getMessage());

            templateEngine.process("listEvents.html", context, resp.getWriter());
            return; // Exit method after processing the error page
        }

        if (events != null) {
            // Set the events in the session
            req.getSession().setAttribute("events", events);

            context.setVariable("events", events);
            templateEngine.process("listEvents.html", context, resp.getWriter());
        }
    }
}
