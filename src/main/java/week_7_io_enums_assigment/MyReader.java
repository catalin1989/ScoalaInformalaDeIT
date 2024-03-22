package week_7_io_enums_assigment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyReader {

    private List<String> data;
    private FileReader myFile;

    public MyReader(FileReader myFile) {
        data=new ArrayList<>();
        this.myFile=myFile;
    }

    public void read(){
        try(BufferedReader reader=new BufferedReader(myFile)){
            String line="";
            while((line= reader.readLine())!=null){
                data.add(line);
            }
        }
        catch (IllegalArgumentException | IOException e){
            System.out.println(e);
        }
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public FileReader getMyFile() {
        return myFile;
    }

    public void setMyFile(FileReader myFile) {
        this.myFile = myFile;
    }
}
