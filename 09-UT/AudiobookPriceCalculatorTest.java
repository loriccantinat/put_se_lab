package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    AudiobookPriceCalculator priceCalculator;
    Audiobook audioBook;

    @BeforeEach
    public void setUp() {
        priceCalculator = new AudiobookPriceCalculator();
        audioBook = new Audiobook("Title of the book",100.0);
    }

    @Test
    void testCalculateSubscriber() {
        //because we change the type of the customer, we can't put the declaration in setUp
        Customer customer = new Customer("Clement", Customer.LoyaltyLevel.STANDARD, true);

        assertEquals(0.0, priceCalculator.calculate(customer, audioBook));

    }

    @Test
    void testCalculateSilver() {
        //because we change the type of the customer, we can't put the declaration in setUp
        Customer customer = new Customer("Clement", Customer.LoyaltyLevel.SILVER, false);

        assertEquals(90.0, priceCalculator.calculate(customer, audioBook));

    }

    @Test
    void testCalculateGold() {
        //because we change the type of the customer, we can't put the declaration in setUp
        Customer customer = new Customer("Clement", Customer.LoyaltyLevel.GOLD, false);

        assertEquals(80.0, priceCalculator.calculate(customer, audioBook));

    }

    @Test
    void testCalculateStandard() {
        //because we change the type of the customer, we can't put the declaration in setUp
        Customer customer = new Customer("Clement", Customer.LoyaltyLevel.STANDARD, false);

        assertEquals(100.0, priceCalculator.calculate(customer, audioBook));

    }
}