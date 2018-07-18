package db;

import models.*;

import java.util.Calendar;
import java.util.Date;
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
        Customer customer7 = new Customer("Curtis Shanks", 500, 112345);
        Customer customer8 = new Customer("George Meltdown", 400, 112233);
        Customer customer9 = new Customer("Betty D. Kearns", 600, 221133);
        Customer customer10 = new Customer("Rodney M. Randall", 300, 332211);
        Customer customer11 = new Customer("Shannon T. Floyd", 250, 798288);
        Customer customer12 = new Customer("Kathryn W. Garcia", 300, 528790);
        Customer customer13 = new Customer("Krystal J. Humphrey", 400, 184890);
        Customer customer14 = new Customer("Jeramy C. Duncan", 125, 944003);
        Customer customer15 = new Customer("Eugene M. Picard", 240, 562697);
        Customer customer16 = new Customer("Jacqueline M. Cotta", 300, 557118);
        Customer customer17 = new Customer("Raymond M. Sizemore", 800, 510826);
        Customer customer18 = new Customer("Ann R. Coleman", 200, 237028);
        Customer customer19 = new Customer("Martin M. Davis", 400, 642224);
        Customer customer20 = new Customer("Jose M. Mize", 500, 846600);

        customer1.setRestaurant(restaurant);
        customer2.setRestaurant(restaurant);
        customer3.setRestaurant(restaurant);
        customer4.setRestaurant(restaurant);
        customer5.setRestaurant(restaurant);
        customer6.setRestaurant(restaurant);
        customer7.setRestaurant(restaurant);
        customer8.setRestaurant(restaurant);
        customer9.setRestaurant(restaurant);
        customer10.setRestaurant(restaurant);
        customer11.setRestaurant(restaurant);
        customer12.setRestaurant(restaurant);
        customer13.setRestaurant(restaurant);
        customer14.setRestaurant(restaurant);
        customer15.setRestaurant(restaurant);
        customer16.setRestaurant(restaurant);
        customer17.setRestaurant(restaurant);
        customer18.setRestaurant(restaurant);
        customer19.setRestaurant(restaurant);
        customer20.setRestaurant(restaurant);

        DBHelper.save(customer1);
        DBHelper.save(customer2);
        DBHelper.save(customer3);
        DBHelper.save(customer4);
        DBHelper.save(customer5);
        DBHelper.save(customer6);
        DBHelper.save(customer7);
        DBHelper.save(customer8);
        DBHelper.save(customer9);
        DBHelper.save(customer10);
        DBHelper.save(customer11);
        DBHelper.save(customer12);
        DBHelper.save(customer13);
        DBHelper.save(customer14);
        DBHelper.save(customer15);
        DBHelper.save(customer16);
        DBHelper.save(customer17);
        DBHelper.save(customer18);
        DBHelper.save(customer19);
        DBHelper.save(customer20);


        Calendar calendar1 = new GregorianCalendar(2018, 7, 1, 18, 00);
        Calendar calendar2 = new GregorianCalendar(2018, 7, 1, 18, 30);
        Calendar calendar3 = new GregorianCalendar(2018, 7, 1, 19, 00);
        Calendar calendar4 = new GregorianCalendar(2018, 7, 1, 19, 30);
        Calendar calendar5 = new GregorianCalendar(2018, 7, 1, 19, 30);
        Calendar calendar6 = new GregorianCalendar(2018, 7, 5, 20, 30);
        Calendar calendar7 = new GregorianCalendar(2018, 7, 6, 19, 00);
        Calendar calendar8 = new GregorianCalendar(2018, 7, 6, 19, 30);
        Calendar calendar9 = new GregorianCalendar(2018, 7, 6, 20, 00);
        Calendar calendar10 = new GregorianCalendar(2018, 7, 2, 20, 00);

        Booking booking1 = new Booking((GregorianCalendar)calendar1,2, customer1, seating1, restaurant);
        Booking booking2 = new Booking((GregorianCalendar)calendar2,2, customer2, seating2, restaurant);
        Booking booking3 = new Booking((GregorianCalendar)calendar3,4, customer3, seating7, restaurant);
        Booking booking4 = new Booking((GregorianCalendar)calendar4,4, customer4, seating8, restaurant);
        Booking booking5 = new Booking((GregorianCalendar)calendar5,6, customer5, seating11, restaurant);
        Booking booking6 = new Booking((GregorianCalendar)calendar6, 4, customer4, seating10, restaurant);
        Booking booking7 = new Booking((GregorianCalendar)calendar6, 6, customer6, seating12, restaurant);
        Booking booking8 = new Booking((GregorianCalendar)calendar7, 6, customer7, seating11, restaurant);
        Booking booking9 = new Booking((GregorianCalendar)calendar8, 4, customer8, seating8, restaurant);
        Booking booking10 = new Booking((GregorianCalendar)calendar9, 6, customer9, seating12, restaurant);
        Booking booking11 = new Booking((GregorianCalendar)calendar10, 2, customer10, seating3, restaurant);
        Booking booking12 = new Booking((GregorianCalendar)calendar3, 2, customer11, seating5, restaurant);
        Booking booking13 = new Booking((GregorianCalendar)calendar7, 4, customer12, seating9, restaurant);
        Booking booking14 = new Booking((GregorianCalendar)calendar8, 2, customer13, seating1, restaurant);
        Booking booking15 = new Booking((GregorianCalendar)calendar9, 2, customer14, seating1, restaurant);
        Booking booking16 = new Booking((GregorianCalendar)calendar3, 2, customer15, seating2, restaurant);
        Booking booking17 = new Booking((GregorianCalendar)calendar4, 2, customer16, seating1, restaurant);
        Booking booking18 = new Booking((GregorianCalendar)calendar5, 6, customer17, seating12, restaurant);
        Booking booking19 = new Booking((GregorianCalendar)calendar6, 2, customer18, seating1, restaurant);
        Booking booking20 = new Booking((GregorianCalendar)calendar3, 4, customer20, seating8, restaurant);

        DBHelper.save(booking1);
        DBHelper.save(booking2);
        DBHelper.save(booking3);
        DBHelper.save(booking4);
        DBHelper.save(booking5);
        DBHelper.save(booking6);
        DBHelper.save(booking7);
        DBHelper.save(booking8);
        DBHelper.save(booking9);
        DBHelper.save(booking10);
        DBHelper.save(booking11);
        DBHelper.save(booking12);
        DBHelper.save(booking13);
        DBHelper.save(booking14);
        DBHelper.save(booking15);
        DBHelper.save(booking16);
        DBHelper.save(booking17);
        DBHelper.save(booking18);
        DBHelper.save(booking19);
        DBHelper.save(booking20);


        List<Booking> bookings = DBBooking.getBookingByDate(calendar1, calendar10);

        List<Customer> customers = DBCustomer.getCustomersByDate(calendar1);



    }
}
