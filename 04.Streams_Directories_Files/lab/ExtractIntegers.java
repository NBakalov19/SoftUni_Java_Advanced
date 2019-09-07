package lab;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {
  public static void main(String[] args) {
    String basePath = "D:\\SoftUni\\Software_Engineering\\JavaFundamentals\\JavaAdvanced" +
            "\\04.StreamsDirectoriesFiles\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

    String inputPath = basePath + "\\input.txt";
    String outputPath = basePath + "\\04.ExtractIntegersOutput.txt";


    try (Scanner inputScanner = new Scanner(new FileInputStream(inputPath));
         FileWriter writer = new FileWriter(outputPath)) {

      while (inputScanner.hasNext()) {
        if (inputScanner.hasNextInt()) {
          writer.write(String.valueOf(inputScanner.nextInt()));
          writer.write('\n');
        }

        inputScanner.next();
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
