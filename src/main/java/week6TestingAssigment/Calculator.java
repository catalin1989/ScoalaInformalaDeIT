package week6TestingAssigment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    List<String> values=new ArrayList<>();


    public void read() throws IOException {

        try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                String data=reader.readLine();
                String[] array=data.split(" ");
                try{
                    int number=Integer.parseInt(array[0]);
                    if(array[1]==null){
                        throw new Exception();
                    }
                }
                catch(Exception e){
                    System.out.println("You haven't entered a valid number and/or unit measurement.Please rerun the program");
                    break;
                }
                if (!array[1].equals("mm") && !array[1].equals("cm") && !array[1].equals("dm")&&!array[1].equals("m")&&!array[1].equals("km")) {
                    System.out.println("Unknown unit measurement format!");
                }
                String sign= reader.readLine();
                if(!sign.equals("+")&&!(sign.equals("-"))&&!sign.equals("=")){
                    System.out.println("Unknown operation type.Please rerun the program");
                    break;
                }
                if(sign.equals("=")){

                    break;
                }
                values.add(data);
                values.add(sign);
            }
        }
    }
}
