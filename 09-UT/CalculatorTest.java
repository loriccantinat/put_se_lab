package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();

    }

    @Test
    void testAdd() {
        //Calculator calculator = new Calculator();

        assertEquals(5, calculator.add(3,2));
        assertEquals(50, calculator.add(37,13));
        assertEquals(-1, calculator.add(-2,1));

    }

    @Test
    void testMultiply() {
        //Calculator calculator = new Calculator();

        assertEquals(6, calculator.multiply(3,2));
        assertEquals(50, calculator.multiply(5,10));
        assertEquals(-4, calculator.multiply(-2,2));

    }

    @Test
    void testAddPositiveNumbers() {

        assertEquals(5, calculator.addPositiveNumbers(2, 3));

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.addPositiveNumbers(-1, 5);
        });
    }

}