package week_10_java_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyReader {

    private List<String> listWithData;

    public MyReader() {
        listWithData = new ArrayList<>();
    }

    public void readData(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String data = "";
            while ((data = reader.readLine()) != null) {
                listWithData.add(data);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<String> getListWithData() {
        return listWithData;
    }
}
