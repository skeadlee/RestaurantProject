package controllers;

import db.DBCustomer;
import db.DBHelper;
import db.DBRestaurant;
import models.Booking;
import models.Customer;
import models.Restaurant;
import models.Seating;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class BookingController {

    public final String restaurantName = "Jurassic Snack";

    public BookingController(){this.setupEndPoints();}

    public void setupEndPoints(){

        //view all bookings
        get("/bookings", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Booking> bookings = DBHelper.getAll(Booking.class);

            model.put("template", "templates/bookings/index.vtl");
            model.put("bookings", bookings);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //new booking form
        get("/bookings/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();

            List<Customer> customers = DBHelper.getAll(Customer.class);

            model.put("template", "templates/bookings/create.vtl");
            model.put("customers", customers);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //adds new booking to db
        post("/bookings", (req, res) -> {
            int customerId = Integer.parseInt(req.queryParams("customer"));
            String date = req.queryParams("date");
            String time = req.queryParams("time");
            int capacity = Integer.parseInt(req.queryParams("capacity"));

            Restaurant restaurant = DBRestaurant.getRestaurant(restaurantName);

            Customer customer = DBCustomer.getCustomer(customerId);

            try {
                Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                Date bookingDate = formatter.parse(date);
                calendar.setTime(bookingDate);

                List<Seating> allTables = DBHelper.getAll(Seating.class);

                Seating seating = Booking.checkForTable(allTables, (GregorianCalendar) calendar, capacity);

                Booking newBooking = new Booking((GregorianCalendar) calendar, capacity, customer, seating, restaurant);
                DBHelper.save(newBooking);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            res.redirect("/bookings");
            return null;

        }, new VelocityTemplateEngine());



    }
}
