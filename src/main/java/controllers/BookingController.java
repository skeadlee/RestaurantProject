package controllers;

import db.DBHelper;
import models.Booking;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class BookingController {

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



    }
}
