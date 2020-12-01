package se.lexicon.negar;



import se.lexicon.negar.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class MachineTest
{
    //a method to test whether addCurrency method works correct
    @Test
    public void addCurrencyTest()
    {
        Machine machine = new Machine();
        machine.addCurrency(10);
        assertEquals(10, machine.getBalance()); //adding initial money
        machine.addCurrency(12);
        assertEquals(10, machine.getBalance()); //add invalid coin
        machine.addCurrency(200);
        assertEquals(210, machine.getBalance()); //add money for the second time
    }

    //a method to test whether request method works correct
    @Test
    public void requestTest()
    {
        Machine machine = new Machine();
        machine.addCurrency(20);
        Product product = machine.request(20);
        assertEquals(null, product); //out of bound
        product = machine.request(7);
        assertEquals(null, product); //not enough money
        product = machine.request(1);
        assertNotNull(product); //a valid purchase
        product = machine.request(5);
        assertEquals(null, product); //not enough money
    }

    //a method to test whether endSession method works correct
    @Test
    public void endSessionTest()
    {
        Machine machine = new Machine();
        machine.addCurrency(500);
        assertEquals(500, machine.endSession()); //test the returned value
        machine.addCurrency(20);
        assertEquals(20, machine.getBalance()); //test if deposit is zero when session is finished
        machine.request(1);
        assertEquals(10, machine.endSession()); //test deposit after buying
        assertEquals(0, machine.endSession()); //test deposit after end session
    }

    //a method to test whether getDescription method works correct
    @Test
    public void getDescriptionTest()
    {
        Machine machine = new Machine();
        String description = machine.getDescription(12);
        assertEquals("", description); //out of bound
        description = machine.getDescription(10);
        boolean has_india = description.contains("India");
        assertTrue(has_india); //test a fruit region
        description = machine.getDescription(2);
        boolean has_sweet = description.contains("sweet");
        assertTrue(has_sweet); //test a candy taste
        description = machine.getDescription(7);
        boolean has_alcohol = description.contains("alcoholic");
        assertTrue(has_alcohol); //test a drink
    }

    //a method to test whether getBalance method works correct
    @Test
    public void getBalanceTest()
    {
        Machine machine = new Machine();
        assertEquals(0, machine.getBalance()); //zero when starts
        machine.addCurrency(100);
        assertEquals(100, machine.getBalance()); //equal to the added value
        machine.request(8);
        assertEquals(55, machine.getBalance()); //equal to the reduced value
        int deposit = machine.endSession();
        assertEquals(0, machine.getBalance()); //zero when session is finished
    }

    //a method to test whether getProducts method works correct
    @Test
    public void getProductsTest()
    {
        Machine machine = new Machine();
        String[] products = machine.getProducts();
        assertEquals(10, products.length); //test products length
        boolean has_mango = products[8].contains("Mango");
        assertTrue(has_mango); //test a specific product name
    }
}

