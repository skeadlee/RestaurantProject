import models.Till;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TillTest {

    Till till;

    @Before
    public void setUp() throws Exception {

        till = new Till (500);
    }

    @Test
    public void canGetBalance() {
        assertEquals(500, till.getAmount());
    }

    @Test
    public void canIncreaseAmount() {
        till.getAmount();
        till.increaseBalance(50);
        assertEquals(550, till.getAmount());
    }
}
