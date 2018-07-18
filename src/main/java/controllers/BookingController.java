package controllers;

import db.DBBooking;
import db.DBCustomer;
import db.DBHelper;
import db.DBRestaurant;
import models.Booking;
import models.Customer;
import models.Restaurant;
import models.Seating;
import org.hibernate.HibernateException;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class BookingController {

    public final String restaurantName = "Jurassic Snack";

    public BookingController(){this.setupEndPoints();}

    public void setupEndPoints(){

        //home page
        get("/", (req, res) ->{
            res.redirect("/bookings");
            return null;
        }, new VelocityTemplateEngine());

        //view all bookings
        get("/bookings", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Booking> bookings = DBBooking.getAllByDate();

            model.put("template", "templates/bookings/index.vtl");
            model.put("bookings", bookings);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //new booking form
        get("/bookings/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();

            List<Customer> customers = DBHelper.getAll(Customer.class);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            model.put("today", dateFormat.format(date));
            model.put("template", "templates/bookings/create.vtl");
            model.put("customers", customers);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //saves new booking to db
        //HH:mm FOR 24h
        post("/bookings", (req, res) -> {
            int customerId = Integer.parseInt(req.queryParams("customer"));
            String date = req.queryParams("date");
            String time = req.queryParams("time");
            int capacity = Integer.parseInt(req.queryParams("capacity"));

            Restaurant restaurant = DBRestaurant.getRestaurant(restaurantName);

            Customer customer = DBCustomer.getCustomer(customerId);

            try {
                String dateTime = date + " " + time;
                Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm");
                Date bookingDate = formatter.parse(dateTime);
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


        post("/bookings/date", (req, res) -> {
            String date = req.queryParams("date");
            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd");
            Date bookingDate = null;
            try {
                bookingDate = formatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendar.setTime(bookingDate);

            Calendar cal2 = (Calendar) calendar.clone();
            cal2.add(Calendar.DATE, 1);


            List<Booking> bookings = DBBooking.getBookingByDate(calendar, cal2);


            HashMap<String, Object> model = new HashMap<>();
            model.put("bookings", bookings);
            model.put("template", "templates/bookings/date.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



        //just trying this out - WORK IN PROGRESS!!!

        //get specific booking - to view, update, delete...
        get("bookings/edit/:id", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(req.params(":id"));

            List<Customer> customers = DBHelper.getAll(Customer.class);
            Booking booking = DBHelper.find(id, Booking.class);
            Customer customer = DBHelper.find(booking.getCustomer().getId(), Customer.class);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            model.put("today", dateFormat.format(date));
            model.put("template", "templates/bookings/edit.vtl");
            model.put("booking", booking);
            model.put("customer", customer);
            model.put("customers", customers);
            model.put("prettyDate", booking.inputDateFormat());
            model.put("time", booking.inputTimeFormat());

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //edits current booking
        post("bookings/edit", (req, res) ->{
            int id = Integer.parseInt(req.queryParams("id"));
            Booking booking = DBHelper.find(id, Booking.class);

            int customerId = Integer.parseInt(req.queryParams("customer"));
            String date = req.queryParams("date");
            String time = req.queryParams("time");
            int capacity = Integer.parseInt(req.queryParams("capacity"));

            Customer customer = DBCustomer.getCustomer(customerId);

            try {
                String dateTime = date + " " + time;
                Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd HH:mm");
                Date bookingDate = formatter.parse(dateTime);
                calendar.setTime(bookingDate);

                booking.setTimeDate((GregorianCalendar)calendar);
            } catch(ParseException e) {
                e.printStackTrace();
            }
            booking.setCustomer(customer);
            booking.setCapacity(capacity);

            DBHelper.save(booking);

            res.redirect("/bookings");
            return null;
        },new VelocityTemplateEngine());

        //deletes booking
        post("bookings/:id/delete", (req, res) ->{
            int id = Integer.parseInt(req.params(":id"));
            Booking booking = DBHelper.find(id, Booking.class);

            DBHelper.delete(booking);

            res.redirect("/bookings");
            return null;
        }, new VelocityTemplateEngine());




    }
}
