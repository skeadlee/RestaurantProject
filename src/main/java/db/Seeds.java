package db;

import models.*;

public class Seeds {

    public static void seedData(){

        DBHelper.deleteAll(Booking.class);
        DBHelper.deleteAll(Customer.class);
        DBHelper.deleteAll(Restaurant.class);
        DBHelper.deleteAll(Seating.class);
        DBHelper.deleteAll(Till.class);
        DBHelper.deleteAll(TimeSlot.class);

        Restaurant restaurant = new Restaurant("Jurassic Snack");
        DBHelper.save(restaurant);

        




    }
}
