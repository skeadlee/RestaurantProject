package db;

import models.*;

public class Seeds {

    public static void seedData() {

//        DBHelper.deleteAll(Booking.class);
//        DBHelper.deleteAll(Customer.class);
//        DBHelper.deleteAll(Restaurant.class);
//        DBHelper.deleteAll(Seating.class);
//        DBHelper.deleteAll(Till.class);

        Restaurant restaurant = new Restaurant("Jurassic Snack");
        DBHelper.save(restaurant);

        Till till = new Till(500);
        DBHelper.save(till);

        Customer customer1 = new Customer("Chris McMillan", 300);
        Customer customer2 = new Customer("Niamh Fraser", 200);
        Customer customer3 = new Customer("Zac Wood", 200);
        Customer customer4 = new Customer("Richard PK", 1000);
        Customer customer5 = new Customer("Karol Jabłoński", 125);
        Customer customer6 = new Customer("Thomas Schulz", 500);

        DBHelper.save(customer1);
        DBHelper.save(customer2);
        DBHelper.save(customer3);
        DBHelper.save(customer4);
        DBHelper.save(customer5);
        DBHelper.save(customer6);

    }
}
