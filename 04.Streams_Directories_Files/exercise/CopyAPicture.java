package exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {
  public static void main(String[] args) throws IOException {

    FileInputStream inputStream = new FileInputStream("D:\\Projects\\JavaFundamentals\\JavaAdvanced\\" +
            "04.StreamsDirectoriesFiles\\resources\\images.jpg");

    byte[] buffer = inputStream.readAllBytes();

    FileOutputStream outputStream = new FileOutputStream("copy-java.jpg");

    outputStream.write(buffer);
    outputStream.close();
  }
}
