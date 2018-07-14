package controllers;

import db.Seeds;

import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {
        staticFileLocation("/public");
        BookingController bookingController = new BookingController();
        //RestaurantController restaurantController = new RestaurantController();
        //CustomerController customerController = new CustomerController();
        Seeds.seedData();
    }
}
