package exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
  public static void main(String[] args) throws IOException {

    FileOutputStream outputStream = new FileOutputStream("archive.zip");
    ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
    String basePath = "D:\\Projects\\JavaFundamentals\\JavaAdvanced\\04.StreamsDirectoriesFiles\\resources";
    FileInputStream inputStream = new FileInputStream(basePath + "\\input.txt");

    zipOutputStream.putNextEntry(new ZipEntry(basePath + "\\input.txt"));
    zipOutputStream.write(inputStream.readAllBytes());
    zipOutputStream.close();
  }
}
