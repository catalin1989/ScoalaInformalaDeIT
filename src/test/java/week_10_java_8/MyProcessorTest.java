package week_10_java_8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyProcessorTest {
    private MyProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new MyProcessor();
        List<String> listWithData = new ArrayList<>();
        listWithData.add("1,Harry,Potter,05.02.2000");
        listWithData.add("2,Hermione,Granger,18.12.1999");
        listWithData.add("3,Sam, Smith, 01.12.1980");
        listWithData.add("4,George, Clooney, 05.07.1960");
        listWithData.add("5, Frank,Sinatra, 31.12.1940");
        processor.setListWithData(listWithData);
    }

    @Test
    void inputHas3Matches_expected3Matches_result3Matches() {
        processor.getCharactersWithSelectedMonth(12);
        int result = processor.getListWithCharacters().size();
        assertEquals(3, result);
    }

    @Test
    void inputWrongMonthNumber_expectedException_resultIllegalArgumentException() {
        boolean flag = false;
        try {
            processor.getCharactersWithSelectedMonth(15);
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertTrue(flag);
    }

    @Test
    void nameInputIsNotGood_expectedException_resultIllegalArgumentException() {
        List<String> listWithCorruptData = new ArrayList<>();
        listWithCorruptData.add("1,Harry,,05.02.2000");//We forgot to enter the last name
        listWithCorruptData.add("2,Hermione,Granger,18.12.1999");
        listWithCorruptData.add("3,Sam, Smith, 01.12.1980");
        listWithCorruptData.add("4,George, Clooney, 05.07.1960");
        processor.setListWithData(listWithCorruptData);
        boolean flag = false;
        try {
            processor.getCharactersWithSelectedMonth(2);
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertTrue(flag);
    }

    @Test
    void inputForBirthDateIsNotGood_expectException_resultIllegalArgumentException() {
        List<String> listWithCorruptData = new ArrayList<>();
        listWithCorruptData.add("1,Harry,Potter,05/02/2000");//We entered the date in the wrong format.
        // The program first checks for the presence of the given month then it compares the two numbers. It will trow an exception only
        // if the positive matches have a bad format.
        listWithCorruptData.add("2,Hermione,Granger,18.12.1999");
        listWithCorruptData.add("3,Sam, Smith, 01.12.1980");
        listWithCorruptData.add("4,George, Clooney, 05.07.1960");
        processor.setListWithData(listWithCorruptData);
        boolean flag = false;
        try {
            processor.getCharactersWithSelectedMonth(2);
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        assertTrue(flag);
    }
}