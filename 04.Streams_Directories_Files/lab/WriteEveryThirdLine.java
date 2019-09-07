package lab;

import java.io.*;

public class WriteEveryThirdLine {
  public static void main(String[] args) throws IOException {
    String basePath = "D:\\SoftUni\\Software_Engineering\\JavaFundamentals\\JavaAdvanced" +
            "\\04.StreamsDirectoriesFiles\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

    String inputPath = basePath + "\\input.txt";
    String outputPath = basePath + "\\05.WriteEveryThirdLineOutput.txt";
    int row = 1;
    try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
         PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {


      String line = reader.readLine();
      while (line != null) {

        if (row % 3 == 0) {

          writer.println(line);
        }
        row++;
        line = reader.readLine();
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }
}
