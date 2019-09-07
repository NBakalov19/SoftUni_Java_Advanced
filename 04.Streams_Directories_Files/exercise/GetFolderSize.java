package exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class GetFolderSize {
  public static void main(String[] args) throws IOException {
    String basePath = "\\resources";

    File file = new File("D:\\Projects\\JavaFundamentals\\JavaAdvanced\\04.StreamsDirectoriesFiles\\resources\\Exercises Resources");

//        long sum =  Arrays.stream(file.listFiles())
//                .filter(e -> e.isFile())
//                .mapToLong(e -> e.length())
//                .sum();

      try (FileWriter writer = new FileWriter("getFolderSizeOutput.txt")) {
          long sum = 0L;

          for (File f : Objects.requireNonNull(file.listFiles())) {
              if (f.isFile()) {
                  sum += f.length();
              }
          }
          writer.write(String.format("Folder size: %d", sum));
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}