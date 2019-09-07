package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class ThePartyReservationFilterModule {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] names = scanner.nextLine().split("\\s+");
    Map<String, Predicate<String>> predicates = new HashMap<>();
    String line = scanner.nextLine();

    while (!line.equals("Print")) {
      String[] tokens = line.substring(line.indexOf(";") + 1).split(";");
      String name = tokens[0] + tokens[1];

      if (line.contains("Add")) {
        Predicate<String> predicate = null;
        switch (tokens[0]) {
          case "Starts with":
            predicate = s -> s.startsWith(tokens[1]);
            break;
          case "Ends with":
            predicate = s -> s.endsWith(tokens[1]);
            break;
          case "Length":
            predicate = s -> s.length() == Integer.parseInt(tokens[1]);
            break;
          case "Contains":
            predicate = s -> s.contains(tokens[1]);
            break;
        }
        predicates.putIfAbsent(name, predicate);
      } else {
        predicates.remove(name);
      }
      line = scanner.nextLine();
    }
    for (String name : names) {
      boolean isValid = true;
      for (String predicateName : predicates.keySet()) {

        if (predicates.get(predicateName).test(name)) {
          isValid = false;
          break;
        }
      }
      if (isValid) {
        System.out.print(name + " ");
      }
    }
  }
}