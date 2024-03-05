package week6TestingAssigment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertorTest {
    private Convertor convertor;

    @BeforeEach
    void setUp() {
        convertor = new Convertor();
    }

    @Test
    void convertToMeters_10KM_successfully() {
        int number = convertor.convertToMeters("km", 10);
        assertEquals(10000, number);
    }

    @Test
    void convertToDecimeters_1Km_successfully() {
        int number = convertor.convertToDecimeters("km", 1);
        assertEquals(10000, number);
    }
}