package lab.maps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfStudents = Integer.parseInt(scanner.nextLine());

    TreeMap<String, Double> graduationList = new TreeMap<>();

    for (int i = 0; i < countOfStudents; i++) {
      String studentName = scanner.nextLine();
      double[] scores = Arrays.stream(scanner.nextLine().split("\\s+"))
              .mapToDouble(Double::parseDouble)
              .toArray();
      double average = 0d;

      for (double score : scores) {
        average += score;
      }
      average /= scores.length;
      graduationList.put(studentName, average);
    }

    for (String studentName : graduationList.keySet()) {
      System.out.println(studentName + " is graduated with " + graduationList.get(studentName));
    }
  }
}