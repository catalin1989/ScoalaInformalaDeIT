package week_7_io_enums_assigment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//This class is responsible for the reading from the CSV file
public class MyReader {

    private List<String> data;


    public MyReader() {
        data = new ArrayList<>();
    }

    public void read(String path) throws IllegalArgumentException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                data.add(line);

            }
        } catch (IOException e) {
            System.out.println(e);
        }
        checkIfDocumentHasAllFieldsFilled();
    }
    //This method checks if all the fields of the document have benn field. We don't want to calculate the winner
    //with missing data

    private void checkIfDocumentHasAllFieldsFilled() throws IllegalArgumentException {
        for (int i = 0; i < data.size(); i++) {
            String[] inputLine = data.get(i).split(",");
            if (inputLine.length != 7) {
                throw new IllegalArgumentException("There is a problem with the fields of the document.Please check line nr. " + i +
                        " and fill it correctly");
            }
        }
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

}
