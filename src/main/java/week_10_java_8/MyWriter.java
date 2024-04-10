package week_10_java_8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyWriter {

    private List<String> listWithCharacters;

    public void setListWithCharacters(List<String> listWithCharacters) {
        this.listWithCharacters = listWithCharacters;
    }

    public void writeToFile(String fileName) throws IOException {
        System.out.println("Starting to write to file!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("First Name, Last Name \n");
            for (String s : listWithCharacters) {
                String[] array = s.split(" ");
                writer.write(array[0] + "," + array[1] + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
