import models.Booking;
import models.Customer;
import models.Restaurant;
import models.Seating;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class RestaurantTest {

    Restaurant restaurant;
    Booking booking1;
    Calendar calendar1;
    Customer customer1;

    @Before
    public void setUp() throws Exception {
        restaurant = new Restaurant("CodeClanChristmasCookHouse");
        booking1 = new Booking((GregorianCalendar)calendar1, 4, customer1, Seating.TABLEFOUR);
    }

    @Test
    public void restaurantHasTables(){
        assertEquals(12, restaurant.getTables().size());
    }

    @Test
    public void restaurantContainsTables() {
        assertEquals(true, restaurant.getTables().contains(Seating.TABLETWO));
        assertEquals(true, restaurant.getTables().contains(Seating.TABLEFOUR));
        assertEquals(true, restaurant.getTables().contains(Seating.TABLESIX));
    }

    @Test
    public void canMakeBooking(){
        restaurant.makeBooking(booking1);
        assertEquals(1, restaurant.getBooking().size());
    }
}
