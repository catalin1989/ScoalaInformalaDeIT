package week6TestingAssigment;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter the values you want to calculate. The program works with mm, cm, dm, m and km");
        System.out.println("The data should be entered in the format <number><space><unit> then press enter then enter the operation type(\"-\", \"+\"). ");
        System.out.println("Ex input:");
        System.out.println("10 m");
        System.out.println("-");
        System.out.println("20 dm");
        System.out.println("=");
        System.out.println("result=80 dm");
        System.out.println("The program will stop accepting values and operations when the = sign is entered");
    Calculator calculator=new Calculator();
    calculator.read();
    }
}
