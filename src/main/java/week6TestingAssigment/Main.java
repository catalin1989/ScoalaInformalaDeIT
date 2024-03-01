package week6TestingAssigment;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter the values you want to calculate. The program works with mm, cm, dm, m and km and the maximum result expressed in mm can be between " + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE);
        System.out.println("The data should be entered in the format <number><space><measurement unit> then press enter then enter the operation type(\"-\", \"+\"). ");
        System.out.println("Ex input:");
        System.out.println("10 m");
        System.out.println("-");
        System.out.println("20 dm");
        System.out.println("=");
        System.out.println("result=80 dm");
        System.out.println("The program will stop accepting values and operations when the = sign is entered");
        Reader reader = new Reader();
        Convertor convertor = new Convertor();
        Calculator calculator = new Calculator(reader, convertor);
        calculator.printTheResult();


    }
}
