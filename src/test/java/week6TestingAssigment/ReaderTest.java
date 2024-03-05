package week6TestingAssigment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    private Reader reader;

    @BeforeEach
    void setUp() {
        reader = new Reader();
    }

    @Test
    void emptyLine_enteredEmptyLine_returnTrue() {
        String[] array = {};
        assertTrue(reader.enteredEmptyLine(array));
    }

    @Test
    void notEmptyLine_enteredANumber_returnFalse() {
        String[] array = {"5"};
        assertFalse(reader.enteredEmptyLine(array));
    }

    @Test
    void negativeNumber_enteredNegativeNumber_returnTrue() {

        assertTrue(reader.enteredNegativeNumber(-5));
    }

    @Test
    void negativeNumber_enteredPositiveNumber_returnFalse() {
        assertFalse(reader.enteredNegativeNumber(5));
    }


}