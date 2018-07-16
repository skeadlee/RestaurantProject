import db.DBHelper;
import db.Seeds;
import models.Booking;
import models.Customer;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Seeds.seedData();

        Customer cust = new Customer("John", 100, 203040);
        DBHelper.save(cust);

        List<Customer> customers = DBHelper.getAll(Customer.class);


    }
}
