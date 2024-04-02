package week_6_testing_assigment;

import junitparams.JUnitParamsRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(JUnitParamsRunner.class)
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

    private static Stream<Arguments> convertValidDataToCm_expectedSuccess(){
        return Stream.of(
                Arguments.of("km",1,100000),
                Arguments.of("m",1,100),
                Arguments.of("dm",100,1000)
        );
    }
    @ParameterizedTest
    @MethodSource
    public void convertValidDataToCm_expectedSuccess(String metricMeasurement, int distance, int expectedResult){
        int result=convertor.convertToCentimeters(metricMeasurement,distance);
        assertEquals(expectedResult,result);
    }


    }

