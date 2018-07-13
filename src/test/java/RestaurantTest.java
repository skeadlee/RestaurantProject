import models.Restaurant;
import models.Seating;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestaurantTest {

    Restaurant restaurant;

    @Before
    public void setUp() throws Exception {
        restaurant = new Restaurant("CodeClanChristmasCookHouse");
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
}
