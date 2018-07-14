package db;

import models.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Seeds {

    public static void seedData() {


        DBHelper.deleteAll(Booking.class);
        DBHelper.deleteAll(Customer.class);
        DBHelper.deleteAll(Restaurant.class);
        DBHelper.deleteAll(Seating.class);
        DBHelper.deleteAll(Till.class);

        Restaurant restaurant = new Restaurant("Jurassic Snack");
        DBHelper.save(restaurant);

        Till till = new Till(500);
        DBHelper.save(till);

        Customer customer1 = new Customer("Chris McMillan", 300, 123456);
        Customer customer2 = new Customer("Niamh Fraser", 200, 223456);
        Customer customer3 = new Customer("Zac Wood", 200, 323456);
        Customer customer4 = new Customer("Richard PK", 1000, 423456);
        Customer customer5 = new Customer("Karol Jabłoński", 125, 523456);
        Customer customer6 = new Customer("Thomas Schulz", 500, 623456);

        customer1.setRestaurant(restaurant);
        customer2.setRestaurant(restaurant);
        customer3.setRestaurant(restaurant);
        customer4.setRestaurant(restaurant);
        customer5.setRestaurant(restaurant);
        customer6.setRestaurant(restaurant);

        DBHelper.save(customer1);
        DBHelper.save(customer2);
        DBHelper.save(customer3);
        DBHelper.save(customer4);
        DBHelper.save(customer5);
        DBHelper.save(customer6);


//        Calendar calendar1 = new GregorianCalendar(2018, 7, 1, 18, 00);
//        Calendar calendar2 = new GregorianCalendar(2018, 7, 1, 18, 30);
//        Calendar calendar3 = new GregorianCalendar(2018, 7, 1, 19, 00);
//        Calendar calendar4 = new GregorianCalendar(2018, 7, 1, 19, 30);
//        Calendar calendar5 = new GregorianCalendar(2018, 7, 1, 19, 30);
//
//        DBHelper.save(calendar1);
//        DBHelper.save(calendar2);
//        DBHelper.save(calendar3);
//        DBHelper.save(calendar4);
//        DBHelper.save(calendar5);

        Booking booking1 = new Booking(4, customer1, Seating.TABLEFOUR);
        Booking booking2 = new Booking(4, customer2, Seating.TABLETWO);
        Booking booking3 = new Booking(4, customer3, Seating.TABLETWO);
        Booking booking4 = new Booking(4, customer4, Seating.TABLESIX);
        Booking booking5 = new Booking(4, customer5, Seating.TABLEFOUR);

        DBHelper.save(booking1);
        DBHelper.save(booking2);
        DBHelper.save(booking3);
        DBHelper.save(booking4);
        DBHelper.save(booking5);

        restaurant.makeBooking(booking1);
        restaurant.makeBooking(booking2);
        restaurant.makeBooking(booking3);
        restaurant.makeBooking(booking4);
        restaurant.makeBooking(booking5);


    }
}
