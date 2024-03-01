package week6TestingAssigment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    Convertor convertor=new Convertor();
    private Reader reader=new Reader();
    private final int mm=1,cm=2,dm=3,m=4,km=5;
    private List<String> mathematicalSigns=new ArrayList<>();
    private List<String> numbersAndUnitMesurements=new ArrayList<>();
    private List<Integer> convertedValues=new ArrayList<>();
    private int minimMeasurmentUnit;
    private boolean errorFlag=false;
    public Calculator(Reader reader,Convertor convertor){
        this.reader=reader;
        this.convertor=convertor;
    }

    private void assignTheInputData(){
        for(int i=0;i<reader.getValues().size();i+=2){
            numbersAndUnitMesurements.add(reader.getValues().get(i));
        }
        for(int i=1;i<reader.getValues().size();i+=2){
            mathematicalSigns.add(reader.getValues().get(i));
        }
    }
    private int determineTheMinimumUnitMeasurment(){
        minimMeasurmentUnit=5;
        List<Integer> valuesOfUnitMeasurment=new ArrayList<>();
        for(String s:numbersAndUnitMesurements){
            String[]array=s.split(" ");
            switch (array[1]){
                case "km":valuesOfUnitMeasurment.add(5);
                break;
                case "m":valuesOfUnitMeasurment.add(4);
                break;
                case "dm":valuesOfUnitMeasurment.add(3);
                break;
                case "cm":valuesOfUnitMeasurment.add(2);
                break;
                case "mm":valuesOfUnitMeasurment.add(1);
                break;
            }
           for(int i:valuesOfUnitMeasurment){
               if(i<minimMeasurmentUnit){
                   minimMeasurmentUnit=i;
               }
           }
        }
        return minimMeasurmentUnit;
    }

    private void convertInputValues(){
        int minim=determineTheMinimumUnitMeasurment();
        switch (minim){
            case 5:for(String s:numbersAndUnitMesurements){
                String[] array=s.split(" ");
                int number=Integer.parseInt(array[0]);
                convertedValues.add(number);
            }
            break;
            case 4:for(String s:numbersAndUnitMesurements){
                String[] array=s.split(" ");
                int number=convertor.convertToMeters(array[1],Integer.parseInt(array[0]));
                convertedValues.add(number);
            }
            break;
            case 3:for(String s:numbersAndUnitMesurements){
                String[] array=s.split(" ");
                int number=convertor.convertToDecimeters(array[1],Integer.parseInt(array[0]));
                convertedValues.add(number);
            }
            break;
            case 2:for(String s:numbersAndUnitMesurements){
                String[] array=s.split(" ");
                int number=convertor.convertToCentimeters(array[1],Integer.parseInt(array[0]));
                convertedValues.add(number);
            }
            break;
            case 1:for(String s:numbersAndUnitMesurements){
                String[] array=s.split(" ");
                int number=convertor.convertToMilimeters(array[1],Integer.parseInt(array[0]));
                convertedValues.add(number);
            }
        }
    }
    private int calculateTheResult(){
        int result=0;
        try{
            if(convertedValues.size()==0){
                errorFlag=true;
                throw new IllegalArgumentException("No numbers to process");

            }
         result=convertedValues.get(0);
        for(int i=0;i<convertedValues.size()-1;i++){
            if(mathematicalSigns.get(i).equals("+")){
                result+=convertedValues.get(i+1);
            }
            else{
                result-=convertedValues.get(i+1);
            }
        }
        return result;
    }catch(Exception e){
            System.out.println("Error");
        }
        return result;
    }
    public void printTheResult(){
        assignTheInputData();
        convertInputValues();
        int result=calculateTheResult();
        if(errorFlag){
            System.out.println("The calculator can't print the result due to an error");
                return;
        }
        switch (minimMeasurmentUnit){
            case 5:
                System.out.println("The result of the operation is: "+result+" km.");
                break;
            case 4:
                System.out.println("The result of the operation is: "+result+" m.");
                break;
            case 3:
                System.out.println("The result of the operation is: "+result+" dm.");
                break;
            case 2:
                System.out.println("The result of the operation is: "+result+" cm.");
                break;
            case 1:
                System.out.println("The result of the operation is: "+result+" mm.");
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
