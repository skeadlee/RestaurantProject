import models.Booking;
import models.Customer;
import models.Seating;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class BookingTest {

    Booking booking;
    Customer customer;
    Seating seating1;
    Seating seating2;
    Seating seating3;
;

    @Before
    public void setUp() throws Exception {
        seating1 = Seating.TABLETWO;
        seating2 = Seating.TABLEFOUR;
        seating3 = Seating.TABLESIX;

        Customer customer1 = new Customer("Regina S. Wilder", 400);
        Customer customer2 = new Customer("Hershel H. Gutierrez", 200);
        Customer customer3 = new Customer("Freddie Thomson", 100);
        Customer customer4 = new Customer("Mason Donaldson", 300);




        Booking booking1 = new Booking(6, customer1, seating1);
        Booking booking2 = new Booking(4, customer1, seating1);
        Booking booking3 = new Booking(2, customer1, seating1);
        Booking booking4 = new Booking(2, customer1, seating1);

    }


}
