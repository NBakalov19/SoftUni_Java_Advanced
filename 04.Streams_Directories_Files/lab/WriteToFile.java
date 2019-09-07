package lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteToFile {
  public static void main(String[] args) {
    String basePath = "D:\\SoftUni\\Software_Engineering\\JavaFundamentals\\JavaAdvanced" +
            "\\04.StreamsDirectoriesFiles\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

    String inputPath = basePath + "\\input.txt";
    String outputPath = basePath + "\\02.WriteToFileOutput.txt";

    List<Character> punctuation = Arrays.asList(',', '.', '?', '!');

    try (FileInputStream inputStream = new FileInputStream(inputPath);
         FileOutputStream outputStream = new FileOutputStream(outputPath)) {
      int byteData = inputStream.read();

      while (byteData >= 0) {
        if (!punctuation.contains((char) byteData)) {
          outputStream.write(byteData);
        }
        byteData = inputStream.read();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
