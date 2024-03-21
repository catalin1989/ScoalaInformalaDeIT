package week6TestingAssigment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//This is the class where all the logic of the calculator is implemented
public class Calculator {
    Convertor convertor;
    private Reader reader;
    // private final int mm=1,cm=2,dm=3,m=4,km=5;
    //in this field I will store the mathematical signs
    private final List<String> mathematicalSigns = new ArrayList<>();
    //in this field I will store all the values imputed from the user ex: 10 km;
    private final List<String> numbersAndUnitMesurements = new ArrayList<>();
    //in this field I will store the converted values 10 km converted to m, it will store 1000
    private final List<Integer> convertedValues = new ArrayList<>();
    private int minimMeasurmentUnit;
    private boolean unitMeasurment = false;

    public Calculator(Reader reader, Convertor convertor) {
        this.reader = reader;
        this.convertor = convertor;
    }

    //This method wil assign the values from the reader. I know that on even positions I have a number and
    // on the even position I have a mathematical sign;
    private void assignTheInputData() {
        for (int i = 0; i < reader.getValues().size(); i += 2) {
            numbersAndUnitMesurements.add(reader.getValues().get(i));
        }
        for (int i = 1; i < reader.getValues().size(); i += 2) {
            mathematicalSigns.add(reader.getValues().get(i));
        }
    }

    //This method will determine the minimum unit measurement. I have assigned a number to the unit measurement
    // mm=1,cm=2,dm=3,m=4,km=5;
    //This will check all the unit measurements in the numbersAndUnitMesurements and will input a number into valuesOfUnitMeasurment
    //Then it will compare the values and return the minimum number
    private int determineTheMinimumUnitMeasurment() {
        minimMeasurmentUnit = 5;
        List<Integer> valuesOfUnitMeasurment = new ArrayList<>();
        for (String s : numbersAndUnitMesurements) {
            String[] array = s.split(" ");
            switch (array[1]) {
                case "km":
                    valuesOfUnitMeasurment.add(5);
                    break;
                case "m":
                    valuesOfUnitMeasurment.add(4);
                    break;
                case "dm":
                    valuesOfUnitMeasurment.add(3);
                    break;
                case "cm":
                    valuesOfUnitMeasurment.add(2);
                    break;
                case "mm":
                    valuesOfUnitMeasurment.add(1);
                    break;
            }
            for (int i : valuesOfUnitMeasurment) {
                if (i < minimMeasurmentUnit) {
                    minimMeasurmentUnit = i;
                }
            }
        }
        return minimMeasurmentUnit;
    }
    //This method, based on the determineTheMinimumUnitMeasurment, will convert all the numbers to the minimum value

    private void convertInputValues() {
        int minim = determineTheMinimumUnitMeasurment();
        switch (minim) {
            case 5:
                for (String s : numbersAndUnitMesurements) {
                    String[] array = s.split(" ");
                    int number = Integer.parseInt(array[0]);
                    convertedValues.add(number);
                }
                break;
            case 4:
                for (String s : numbersAndUnitMesurements) {
                    String[] array = s.split(" ");
                    int number = convertor.convertToMeters(array[1], Integer.parseInt(array[0]));
                    convertedValues.add(number);
                }
                break;
            case 3:
                for (String s : numbersAndUnitMesurements) {
                    String[] array = s.split(" ");
                    int number = convertor.convertToDecimeters(array[1], Integer.parseInt(array[0]));
                    convertedValues.add(number);
                }
                break;
            case 2:
                for (String s : numbersAndUnitMesurements) {
                    String[] array = s.split(" ");
                    int number = convertor.convertToCentimeters(array[1], Integer.parseInt(array[0]));
                    convertedValues.add(number);
                }
                break;
            case 1:
                for (String s : numbersAndUnitMesurements) {
                    String[] array = s.split(" ");
                    int number = convertor.convertToMilimeters(array[1], Integer.parseInt(array[0]));
                    convertedValues.add(number);
                }
        }
    }

    //This method will do all the math
    //It assigns the first value to the result, then it goes it checks the mathematical sign in the mathematicalSigns
    //and performs the requested operation
    private int calculateTheResult() {
        int result = 0;
        try {
            if (convertedValues.isEmpty()) {
                unitMeasurment = true;
                throw new IllegalArgumentException("No numbers to process");

            }
            result = convertedValues.get(0);
            for (int i = 0; i < convertedValues.size() - 1; i++) {
                if (mathematicalSigns.get(i).equals("+")) {
                    result += convertedValues.get(i + 1);
                } else {
                    result -= convertedValues.get(i + 1);
                }
            }
            return result;
        } catch (Exception e) {
            System.out.println("Error");
        }
        return result;
    }

    //I wanted to encapsulate all the important methods and give acces to the user only to the printTheResult method
    //This method calls all the important methods of the other objects and the own methods and prints the resul.
    public void printTheResult() throws IOException {
        reader.read();
        assignTheInputData();
        convertInputValues();
        int result = calculateTheResult();
        if (unitMeasurment) {
            System.out.println("The calculator can't print the result due to an error");
            return;
        }
        switch (minimMeasurmentUnit) {
            case 5:
                System.out.println("The result of the operation is: " + result + " km.");
                break;
            case 4:
                System.out.println("The result of the operation is: " + result + " m.");
                break;
            case 3:
                System.out.println("The result of the operation is: " + result + " dm.");
                break;
            case 2:
                System.out.println("The result of the operation is: " + result + " cm.");
                break;
            case 1:
                System.out.println("The result of the operation is: " + result + " mm.");
                break;
        }
    }


    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setConvertor(Convertor convertor) {
        this.convertor = convertor;
    }

}
