package week_7_io_enums_assigment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MyReaderTest {
    private MyReader reader;
    private static final String resourcesPath = new StringBuilder()
            .append("src")
            .append(File.separator)
            .append("main")
            .append(File.separator)
            .append("resources")
            .append(File.separator)
            .toString();

    @BeforeEach
    void settUp() {
        reader = new MyReader();
    }

    @Test
    void readFromAProperDocument_allLinesHaveBeenRead_resultSuccessful() {
        String fileName = "AthletesCorrectDocumentForTest.csv";
        reader.read(resourcesPath + fileName);
        assertEquals(4, reader.getData().size());
    }

    @Test
    void readFromAnImproperFilledDocument_expectAnError_resultIllegalArgumentException() {
        String fileName = "AthletesImproperFilledDocument.csv";
        boolean flag = false;
        try {
            reader.read(resourcesPath + fileName);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            flag = true;
        }
        assertTrue(flag);
    }

}