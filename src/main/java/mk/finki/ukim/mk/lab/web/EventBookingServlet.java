package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EventBookingServlet", urlPatterns = "/servlet/eventBooking")
public class EventBookingServlet extends HttpServlet {
    private final SpringTemplateEngine templateEngine;
    private final EventBookingService eventBookingService;

    public EventBookingServlet(SpringTemplateEngine templateEngine, EventBookingService eventBookingService) {
        this.templateEngine = templateEngine;
        this.eventBookingService = eventBookingService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("bookings", eventBookingService.listAll());

        templateEngine.process("bookingConfirmation.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        String text = req.getParameter("text");

        List<EventBooking> bookings = null;

        try {
            bookings = eventBookingService.searchEvents(text);


        } catch (RuntimeException exception) {
            // If an exception is thrown, set the hasError variable to true and set the error message
            context.setVariable("hasError", true);
            context.setVariable("error", exception.getMessage());

            templateEngine.process("listEvents.html", context, resp.getWriter());
            return; // Exit method after processing the error page
        }

        if (bookings != null) {
            // Set the events in the session
            req.getSession().setAttribute("bookings", bookings);

            context.setVariable("bookings", bookings);

            templateEngine.process("bookingConfirmation.html", context, resp.getWriter());
//            resp.sendRedirect("/servlet/eventBooking");

        }

    }


}
