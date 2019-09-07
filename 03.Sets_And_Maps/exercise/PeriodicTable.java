package exercise;

import java.util.*;
import java.util.stream.Collectors;

public class PeriodicTable {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfLines = Integer.parseInt(scanner.nextLine());
    TreeSet<String> elements = new TreeSet<>();
    for (int i = 0; i < countOfLines; i++) {
      List<String> input = Arrays.stream(scanner.nextLine().split("\\s+"))
              .collect(Collectors.toList());
      elements.addAll(input);
    }

    for (String element : elements) {
      System.out.print(element + " ");
    }
  }
}
