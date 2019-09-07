package lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;

public class ListFiles {
  public static void main(String[] args) {

    String basePath = "D:\\SoftUni\\Software_Engineering\\JavaFundamentals\\JavaAdvanced" +
            "\\04.StreamsDirectoriesFiles\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

    String inputFileName = basePath + "\\Files-and-Streams";
    String outputFileName = basePath + "\\07.ListFiles.txt";

    File folderToRead = new File(inputFileName);
    try (PrintWriter writer = new PrintWriter(outputFileName)) {
      File[] files = folderToRead.listFiles();

      for (File file : Objects.requireNonNull(files)) {
        if (!file.isDirectory()) {
          writer.printf("%s: [%d]\n", file.getName(), file.length());
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
