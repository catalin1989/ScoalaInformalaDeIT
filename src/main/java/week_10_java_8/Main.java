package week_10_java_8;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final String resourcesPath = "src" +
            File.separator +
            "main" +
            File.separator +
            "resources" +
            File.separator;

    public static void main(String[] args) throws IOException {

         String fileNameForReading="MovieCharacters.csv";
         String fileNameForWriting="MovieCharactersFilteredByMonthOfBirth.csv";
try {
    MyReader reader=new MyReader();
    reader.readData(resourcesPath + fileNameForReading);
    MyProcessor processor = new MyProcessor();
    processor.setListWithData(reader.getListWithData());
    processor.getCharactersWithSelectedMonth(12);
    processor.writeToFile(resourcesPath + fileNameForWriting);
}
catch (IllegalArgumentException e){
    System.out.println(e);
}

    }
}
