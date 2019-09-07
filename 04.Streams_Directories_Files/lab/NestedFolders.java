package lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class NestedFolders {
  public static void main(String[] args) {
    String basePath = "D:\\SoftUni\\Software_Engineering\\JavaFundamentals\\JavaAdvanced" +
            "\\04.StreamsDirectoriesFiles\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

    String inputFileName = basePath + "\\Files-and-Streams";
    String outputFileName = basePath + "\\NestedFolders.txt";

    File folderToRead = new File(inputFileName);
    int folderCount = 0;
    try (PrintWriter writer = new PrintWriter(outputFileName)) {
      ArrayDeque<File> filesToTravers =
              new ArrayDeque<>(Collections.singletonList(folderToRead));

      while (!filesToTravers.isEmpty()) {
        File curr = filesToTravers.poll();
        if (curr.isDirectory()) {
          folderCount++;
          filesToTravers.addAll(Arrays.asList(Objects.requireNonNull(curr.listFiles())));
          writer.println(curr.getName());
        }
      }
      writer.println(folderCount + " folders");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
