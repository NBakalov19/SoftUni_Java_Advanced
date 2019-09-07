package exercise;

import java.io.*;

public class SumLines {
  public static void main(String[] args) throws IOException {

    String basePath = "D:\\Projects\\JavaFundamentals\\JavaAdvanced\\04.StreamsDirectoriesFiles\\resources";
    FileInputStream inputStream = new FileInputStream(basePath + "\\input.txt");
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String line = reader.readLine();

    while (line != null) {

      int sum = 0;

      for (int i = 0; i < line.length(); i++) {

        sum += line.charAt(i);
      }
      System.out.println(sum);
      line = reader.readLine();
    }
  }
}