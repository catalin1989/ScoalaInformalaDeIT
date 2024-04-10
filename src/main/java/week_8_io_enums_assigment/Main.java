package week_8_io_enums_assigment;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static final String resourcesPath = "src" +
            File.separator +
            "main" +
            File.separator +
            "resources" +
            File.separator;

    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = "Athletes.csv";

        MyReader reader1 = new MyReader();
        try {
            reader1.read(resourcesPath + inputFileName);
            MyCalculator calculator = new MyCalculator();
            calculator.processTime(reader1.getData());
            calculator.createAthletesAndAddThemToTheSet();
            MyPrinter.printTheTop3(calculator.getSortedAthletesByTime());
            System.out.println();
            MyPrinter.printAllTheResult(calculator.getSortedAthletesByTime());
        }
        catch (IllegalArgumentException e){
            System.err.println(e);

        }
    }
}
