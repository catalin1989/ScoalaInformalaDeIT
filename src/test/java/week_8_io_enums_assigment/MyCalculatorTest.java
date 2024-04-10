package week_8_io_enums_assigment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {

    private MyCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new MyCalculator();
    }

    @Test
    void noDataToAnalyze_expectedToThrowAnException_resultSuccessfully() {
        List<String> data = new ArrayList<>();
        boolean exceptionThrown = false;
        try {
            calculator.processTime(data);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    void invalidShootingRangeData_expectedToThrowAnException_resultSuccessfully() {
        List<String> data = new ArrayList<>();
        data.add("AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting");
        data.add("1,Florin Prunea,RO,30:15,xxxox,xxoox,xxoox");
        data.add("2,Ioan Lupescu,CO,29:45,xxoxo,xxxox,xcaod");
        boolean exceptionThrown = false;
        try {
            calculator.processTime(data);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    void typoInTimeData_expectedToThrowAnException_resultSuccessfully() {
        List<String> lines = new ArrayList<>();
        lines.add("AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting");
        lines.add("1,Florin Prunea,RO,30w:15,xxxox,xxoox,xxoox");
        boolean exceptionThrown = false;
        try {
            calculator.processTime(lines);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
            System.out.println(e);
        }
        assertTrue(exceptionThrown);
    }

    @Test
    void timeIsNotInMinAndSec_expectedToThrowAnException_resultSuccessfully() {
        List<String> lines = new ArrayList<>();
        lines.add("AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting");
        lines.add("1,Florin Prunea,RO,3015,xxxox,xxoox,xxoox");
        boolean exceptionThrown = false;
        try {
            calculator.processTime(lines);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
            System.out.println(e);
        }
        assertTrue(exceptionThrown);
    }

    @Test
    void timeImputedIsNegative_expectedToThrowAnException_resultSuccessfully() {
        List<String> lines = new ArrayList<>();
        lines.add("AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting");
        lines.add("1,Florin Prunea,RO,-30:15,xxxox,xxoox,xxoox");
        boolean exceptionThrown = false;
        try {
            calculator.processTime(lines);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
            System.out.println(e);
        }
        assertTrue(exceptionThrown);
    }

    @Test
    void validDataInput_testingToSeeIfTheCorrectNumberOfAthletesHasBeenCreated_resultSuccessfully() {
        List<String> lines = new ArrayList<>();
        lines.add("AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting");
        lines.add("1,Florin Prunea,RO,30:15,xxxox,xxoox,xxoox");
        lines.add("2,Ioan Lupescu,CO,29:45,xxoxo,xxxox,xxxox");
        lines.add("3,Gheorghe Popescu,DK,29:30,xxoox,xxxox,xxxox");
        calculator.processTime(lines);
        assertEquals(3, calculator.getAthletesNameAndTime().entrySet().size());
    }

    @Test
    void validDataInput_testingToSeeIfTheTimeIsCalculatedCorrectly_resultSuccessfully() {
        List<String> lines = new ArrayList<>();
        lines.add("AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting");
        lines.add("1,Florin Prunea,RO,30:15,xxxox,xxoox,xxoox");//This time should be 30:15+50 sec from penalty=31:05
        lines.add("2,Ioan Lupescu,CO,29:45,xxoxo,xxxox,xxxox");//This time should be 29:45+40 sec from penalty=30:25
        lines.add("3,Gheorghe Popescu,DK,29:30,xxoxx,xxxox,xxxox");//This time should be 29:30+30 sec from penalty=30:00
        lines.add("4,Viorel Moldovan,ES,31:00,xxoox,xxxox,xxxxo");//This time should be 31:00+40 sec from penalty=31:40
        calculator.processTime(lines);
        String timeForFlorinPrunea = calculator.getAthletesNameAndTime().get("Florin Prunea").get(0);
        String timeForIoanLupescu = calculator.getAthletesNameAndTime().get("Ioan Lupescu").get(0);
        String timeForGheorghePopescu = calculator.getAthletesNameAndTime().get("Gheorghe Popescu").get(0);
        String timeForViorelMoldovan = calculator.getAthletesNameAndTime().get("Viorel Moldovan").get(0);
        boolean flagForPrunea = "31:05".equals(timeForFlorinPrunea);
        boolean flagForLupescu = "30:25".equals(timeForIoanLupescu);
        boolean flagForPopescu = "30:00".equals(timeForGheorghePopescu);
        boolean flagForMoldovan = "31:40".equals(timeForViorelMoldovan);
        assertTrue(flagForPrunea);
        assertTrue(flagForLupescu);
        assertTrue(flagForPopescu);
        assertTrue(flagForMoldovan);
    }


}