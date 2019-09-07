package lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
  public static void main(String[] args) {
    String basePath = "D:\\SoftUni\\Software_Engineering\\JavaFundamentals\\JavaAdvanced" +
            "\\04.StreamsDirectoriesFiles\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

    String inputPath = basePath + "\\input.txt";
    String outputPath = basePath + "\\03.CopyBytesOutput.txt ";


    try (FileInputStream inputStream = new FileInputStream(inputPath);
         FileOutputStream outputStream = new FileOutputStream(outputPath)) {

      int byteData = inputStream.read();

      while (byteData >= 0) {

        if (byteData == ' ' || byteData == '\n') {
          outputStream.write(byteData);
        } else {
          String digits = String.valueOf(byteData);

          for (int i = 0; i < digits.length(); i++) {
            outputStream.write(digits.charAt(i));
          }
        }
        byteData = inputStream.read();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
