package db;

import models.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Seeds {

    public static void seedData() {


        DBHelper.deleteAll(Booking.class);
        DBHelper.deleteAll(Customer.class);
        DBHelper.deleteAll(Restaurant.class);
        DBHelper.deleteAll(Seating.class);
        DBHelper.deleteAll(Till.class);

        Restaurant restaurant = new Restaurant("Jurassic Snack");
        DBHelper.save(restaurant);

        Seating seating1 = new Seating(2, "T1", restaurant);
        Seating seating2 = new Seating(2, "T2", restaurant);
        Seating seating3 = new Seating(2, "T3", restaurant);
        Seating seating4 = new Seating(2, "T4", restaurant);
        Seating seating5 = new Seating(2, "T5", restaurant);
        Seating seating6 = new Seating(2, "T6", restaurant);
        Seating seating7 = new Seating(4, "T7", restaurant);
        Seating seating8 = new Seating(4, "T8", restaurant);
        Seating seating9 = new Seating(4, "T9", restaurant);
        Seating seating10 = new Seating(4, "T10", restaurant);
        Seating seating11 = new Seating(6, "T11", restaurant);
        Seating seating12 = new Seating(6, "T12", restaurant);

        DBHelper.save(seating1);
        DBHelper.save(seating2);
        DBHelper.save(seating3);
        DBHelper.save(seating4);
        DBHelper.save(seating5);
        DBHelper.save(seating6);
        DBHelper.save(seating7);
        DBHelper.save(seating8);
        DBHelper.save(seating9);
        DBHelper.save(seating10);
        DBHelper.save(seating11);
        DBHelper.save(seating12);

        Till till = new Till(500);
        till.setRestaurant(restaurant);
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


        Calendar calendar1 = new GregorianCalendar(2018, 7, 1, 18, 00);
        Calendar calendar2 = new GregorianCalendar(2018, 7, 1, 18, 30);
        Calendar calendar3 = new GregorianCalendar(2018, 7, 1, 19, 00);
        Calendar calendar4 = new GregorianCalendar(2018, 7, 1, 19, 30);
        Calendar calendar5 = new GregorianCalendar(2018, 7, 1, 19, 30);

        Booking booking1 = new Booking((GregorianCalendar)calendar1,2, customer1, seating1, restaurant);
        Booking booking2 = new Booking((GregorianCalendar)calendar2,2, customer2, seating2, restaurant);
        Booking booking3 = new Booking((GregorianCalendar)calendar3,4, customer3, seating7, restaurant);
        Booking booking4 = new Booking((GregorianCalendar)calendar4,4, customer4, seating8, restaurant);
        Booking booking5 = new Booking((GregorianCalendar)calendar5,6, customer5, seating11, restaurant);

        DBHelper.save(booking1);
        DBHelper.save(booking2);
        DBHelper.save(booking3);
        DBHelper.save(booking4);
        DBHelper.save(booking5);

        List<Booking> bookings = DBBooking.getBookingByDate(calendar1);

//        restaurant.makeBooking(booking1);
//        restaurant.makeBooking(booking2);
//        restaurant.makeBooking(booking3);
//        restaurant.makeBooking(booking4);
//        restaurant.makeBooking(booking5);


        //List<Booking> allBookings = DBHelper.getAll(Booking.class);


    }
}
