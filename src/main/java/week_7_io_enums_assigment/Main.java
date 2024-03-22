package week_7_io_enums_assigment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static final String resourcesPath=new StringBuilder()
            .append("src")
            .append(File.separator)
            .append("main")
            .append(File.separator)
            .append("resources")
            .append(File.separator)
            .toString();

    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName="Athletes.csv";

        FileReader reader=new FileReader(resourcesPath+inputFileName);
        MyReader reader1=new MyReader(reader);
        reader1.read();
        MyCalculator calculator=new MyCalculator();
        calculator.processTime(reader1.getData());
       calculator.createAthletesAndAddThemToTheSet();
     Results.printTheTop3(calculator.getSortedAthletesByTime());


    }
}
