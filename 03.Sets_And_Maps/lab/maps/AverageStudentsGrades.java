package lab.maps;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int numberOfStudents = Integer.parseInt(scanner.nextLine());

    Map<String, ArrayList<Double>> classBook = new TreeMap<>();

    for (int i = 0; i < numberOfStudents; i++) {
      String[] studentsWithGrades = scanner.nextLine().split("\\s+");
      String student = studentsWithGrades[0];
      double grade = Double.parseDouble(studentsWithGrades[1]);

      if (!classBook.containsKey(student)) {
        classBook.put(student, new ArrayList<>());
        classBook.get(student).add(grade);
      } else {
        classBook.get(student).add(grade);
      }
    }

    classBook.forEach((key, grades) -> {
      System.out.printf("%s -> ", key);
      grades.forEach(grade -> System.out.printf("%.2f ", grade));
      double average = 0d;
      for (Double grade : grades) {
        average += grade;
      }
      average /= grades.size();
      System.out.println(String.format("(avg: %.2f)", average));
    });
  }
}