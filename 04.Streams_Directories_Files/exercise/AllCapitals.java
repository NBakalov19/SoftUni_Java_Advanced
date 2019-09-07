package exercise;

import java.io.*;

public class AllCapitals {
  public static void main(String[] args) {
    String basePath = "D:\\Projects\\JavaFundamentals\\JavaAdvanced\\04.StreamsDirectoriesFiles\\resources";

    String inputPath = basePath + "\\input.txt";
    try (FileInputStream inputStream = new FileInputStream(inputPath);
         FileWriter writer = new FileWriter(basePath + "\\output.txt")) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String line = reader.readLine();

      while (line != null) {
        StringBuilder sb = new StringBuilder(line);
        for (int index = 0; index < line.length(); index++) {
          char symbol = line.charAt(index);

          if (Character.isLetter(symbol) && Character.isLowerCase(symbol)) {
            sb.setCharAt(index, Character.toUpperCase(symbol));
          }
        }
        writer.write(sb.toString() + System.lineSeparator());
        line = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
