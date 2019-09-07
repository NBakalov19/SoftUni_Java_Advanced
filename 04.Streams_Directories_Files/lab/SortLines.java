package lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
  public static void main(String[] args) {

    String basePath = "D:\\SoftUni\\Software_Engineering\\JavaFundamentals\\JavaAdvanced" +
            "\\04.StreamsDirectoriesFiles\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

    String inputFileName = basePath + "\\inputForSort.txt";
    String outputFileName = basePath + "\\06.SortLinesOutput.txt";

    Path inputPath = Paths.get(inputFileName);
    Path outputPath = Paths.get(outputFileName);
    try {
      List<String> allLines = Files.readAllLines(inputPath);
      Collections.sort(allLines);
      Files.write(outputPath, allLines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}