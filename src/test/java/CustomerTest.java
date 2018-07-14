import models.Booking;
import models.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;
    Booking booking;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Richard", 100, 112334);
        booking = new Booking();
    }

    @Test
    public void customerHasNameAndWalletNoBookings() {
        assertEquals("Richard", customer.getName());
        assertEquals(100, customer.getWallet());
        assertEquals(0, customer.getBookings().size());
    }

    @Test
    public void canAddLoyaltyPoints(){
        customer.addLoyaltyPoints(1);
        assertEquals(1, customer.getLoyaltyCard());
    }

    @Test
    public void canAddBooking(){
        customer.addBookings(booking);
        assertEquals(1, customer.getBookings().size());
    }
}
