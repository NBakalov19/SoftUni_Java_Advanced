package exercise;

import java.io.*;

public class SumBytes {
  public static void main(String[] args) throws IOException {
    String basePath = "D:\\Projects\\JavaFundamentals\\JavaAdvanced\\04.StreamsDirectoriesFiles\\resources";
    FileInputStream inputStream = new FileInputStream(basePath + "\\input.txt");
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String line = reader.readLine();

    long sum = 0L;
    while (line != null) {

      for (int i = 0; i < line.length(); i++) {
        sum += line.charAt(i);
      }

      line = reader.readLine();
    }
    System.out.println(sum);
  }
}
