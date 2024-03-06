package week6TestingAssigment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @ValueSource(strings={"km","m","dm","cm","mm"})
    void enteredValidMetricMeasurementUnits(String input){
        assertFalse(reader.enteredUnknownUnitMeasurement(input));
    }


}