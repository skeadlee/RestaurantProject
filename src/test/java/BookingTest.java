import models.Booking;
import models.Customer;
import models.Table;
import org.junit.Before;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class BookingTest {

    Booking booking;
    Customer customer;
    Table table;

    @Before
    public void setUp() throws Exception {
        Table table1 = new Table();
        Table table2 = new Table();
        Table table3 = new Table();

        Customer customer1 = new Customer("Regina S. Wilder", 400);
        Customer customer2 = new Customer("Hershel H. Gutierrez", 200);
        Customer customer3 = new Customer("Freddie Thomson", 100);
        Customer customer4 = new Customer("Mason Donaldson", 300);

        Calendar calendar1 = new GregorianCalendar(2018, 7, 1, 18, 00);
        Calendar calendar2 = new GregorianCalendar(2018, 7, 1, 18, 30);
        Calendar calendar3 = new GregorianCalendar(2018, 7, 1, 19, 00);
        Calendar calendar4 = new GregorianCalendar(2018, 7, 1, 19, 30);
        Calendar calendar5 = new GregorianCalendar(2018, 7, 1, 19, 30);

        Booking booking1 = new Booking((GregorianCalendar) calendar1, 6, customer1, table1, 50, 0.90);
        Booking booking2 = new Booking((GregorianCalendar) calendar1, 4, customer1, table1, 50, 0.90);
        Booking booking3 = new Booking((GregorianCalendar) calendar1, 2, customer1, table1, 50, 0.90);
        Booking booking4 = new Booking((GregorianCalendar) calendar1, 2, customer1, table1, 50, 0.90);
    }
}
