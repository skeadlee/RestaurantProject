import models.Booking;
import models.Customer;
import models.Restaurant;
import models.Table;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class BookingTest {

    Booking booking;
    Customer customer;
    Table table1;
    Table table2;
    Table table3;
    Restaurant restaurant;
;

    @Before
    public void setUp() throws Exception {
        table1 = Table.TABLETWO;
        table2 = Table.TABLEFOUR;
        table3 = Table.TABLESIX;

        Customer customer1 = new Customer("Regina S. Wilder", 400);
        Customer customer2 = new Customer("Hershel H. Gutierrez", 200);
        Customer customer3 = new Customer("Freddie Thomson", 100);
        Customer customer4 = new Customer("Mason Donaldson", 300);


        Booking booking1 = new Booking(1900, 2, customer1, table1);

    }

    @Test
    public void canMakeBooking() {
    }
}
