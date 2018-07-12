import models.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Richard", 100);
    }

    @Test
    public void customerHasNameAndWalletNoBookings() {
        assertEquals("Richard", customer.getName());
        assertEquals(100, customer.getWallet());
        assertEquals(0, customer.getBookings().size());
    }
}
