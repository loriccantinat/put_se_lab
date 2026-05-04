package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FailureOrErrorTest {

    @Test
    void test1() {
        //always false
        assertEquals(1,2);
    }

    @Test
    void test2() {
        //throws arbitrary exception
        throw new RuntimeException("This is an error");

    }

    @Test
    void test3() {
        try {
            //always false
            assertEquals(1,2);
        } catch (Throwable e){
            //stackTrace for the captured object
            e.printStackTrace();
        }
    }
}
