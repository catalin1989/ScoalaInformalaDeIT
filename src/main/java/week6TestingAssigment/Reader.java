package week6TestingAssigment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//This class is responsible for the input from the user
public class Reader {
    //It stores the values from the user in an ArrayList
    private List<String> values = new ArrayList<>();


    public List<String> getValues() {
        return values;
    }

    //This method uses a try-with-resources to automatically close the BufferedReader at the end
    //It accepts a line with a value ex: 10 km and the nex line a mathematical sign like + - =
    //For the values I have protected the method by not allowing the user to enter an empty field,
    //a negative number, a number without a unit measurement, and an unknown unit measurement. If the user tries
    //to input the above examples, the program will stop and it will show us the reason why it has stopped.
    //For the mathematical signs, if the user tries to enter something else, they will get an error with a message.
    protected void read() throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String data = reader.readLine();
                String[] array = data.split(" ");
                try {
                    if (array.length == 1) {
                        throw new IllegalArgumentException("You entered an empty line!");
                    }
                    int number = Integer.parseInt(array[0]);
                    if (number < 0) {
                        throw new IllegalArgumentException("You entered a negative number. A distance can't be negative!");
                    }
                    if (array[1] == null) {
                        throw new IllegalArgumentException("You haven't entered a unit measurement!");
                    }
                    if (!array[1].equals("mm") && !array[1].equals("cm") && !array[1].equals("dm") && !array[1].equals("m") && !array[1].equals("km")) {
                        throw new IllegalArgumentException("Unknown unit measurement format!");

                    }
                    values.add(data);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }

                //If the user inputs an unknown mathematical sign, the method will clean the values ArrayList.
                String sign = reader.readLine();
                try {
                    if (!sign.equals("+") && !(sign.equals("-")) && !sign.equals("=")) {
                        values.clear();
                        throw new IllegalArgumentException("Unknown operation type.Please rerun the program");

                    }
                    if (sign.equals("=")) {
                        break;
                    }
                    values.add(sign);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }


            }
        }


    }
}
