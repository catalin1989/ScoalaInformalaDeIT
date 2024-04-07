package week_10_java_8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyProcessor {
    private List<String> listWithData;
    private List<String> listWithCharacters;

    public void getCharactersWithSelectedMonth(int monthNumber){
        if(monthNumber<1||monthNumber>12){
            throw new IllegalArgumentException("No such month exist");
        }
        String month;
        if(monthNumber<10){
            month="0"+monthNumber;
        }
        else{
            month=String.valueOf(monthNumber);
        }

        String finalMonth = month;
        listWithCharacters =listWithData
                .stream()
                .filter(s->matchTheMonth(s, finalMonth))
                .map(this::getFirstAndLastName)
                .sorted()
                .collect(Collectors.toList());
        if(listWithCharacters.isEmpty()){
            System.out.println("We haven't found any match for the selected month.");
        }else{
            System.out.println("We have found "+listWithCharacters.size()+" matches.");
        }
    }
    private boolean matchTheMonth(String s,String monthNumber){

                if(!s.contains(monthNumber)){
                    return false;
                }
                String[] arrayOfData = s.split(",");
                if(arrayOfData.length!=4){
                    throw new IllegalArgumentException("You have a problem with the input of the file. You have forgot to enter a filed!");
                }
                String[] arrayOfBirthDate = arrayOfData[3].split("\\.");
                if(arrayOfBirthDate.length!=3){
                    throw new IllegalArgumentException("You haven't entered the birth date in the required format dd.mm.yyyy");
                }
                String month = arrayOfBirthDate[1];
                return month.equals(monthNumber);
            }
    private String getFirstAndLastName(String s){
        String[] array=s.split(",");
        if(array[1].isEmpty()||array[2].isEmpty()){
            throw new IllegalArgumentException("You have a blank first name or last name");
        }
        return String.format("%s %s",array[1],array[2]);
    }



    public List<String> getListWithData() {
        return listWithData;
    }

    public void setListWithData(List<String> listWithData) {
        this.listWithData = listWithData;
    }

    public List<String> getListWithCharacters() {
        return listWithCharacters;
    }

    public void setListWithCharacters(List<String> listWithCharacters) {
        this.listWithCharacters = listWithCharacters;
    }
}

