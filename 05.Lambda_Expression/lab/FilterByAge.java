package lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfPersons = Integer.parseInt(scanner.nextLine());

    Map<String, Integer> people = new LinkedHashMap<>();

    for (int i = 0; i < countOfPersons; i++) {
      String[] personData = scanner.nextLine().split(", ");
      String name = personData[0];
      int age = Integer.parseInt(personData[1]);

      people.put(name, age);
    }

    String comparison = scanner.nextLine();
    int limitAge = Integer.parseInt(scanner.nextLine());
    String printType = scanner.nextLine();

    BiPredicate<Map.Entry<String, Integer>, Integer> youngerThan =
            (person, age) -> person.getValue() < age;

    BiPredicate<Map.Entry<String, Integer>, Integer> olderThan =
            (person, age) -> person.getValue() >= age;

    BiPredicate<Map.Entry<String, Integer>, Integer> byAge = youngerThan;
    if (comparison.equals("older")) {
      byAge = olderThan;
    }

    Consumer<Map.Entry<String, Integer>> printNameAndAge = person ->
            System.out.println(String.format("%s - %d", person.getKey(), person.getValue()));
    Consumer<Map.Entry<String, Integer>> printName = person ->
            System.out.println(person.getKey());
    Consumer<Map.Entry<String, Integer>> printAge = person ->
            System.out.println(person.getValue());

    Consumer<Map.Entry<String, Integer>> print = printNameAndAge;

    if (printType.equals("name")) {
      print = printName;
    } else if (printType.equals("age")) {
      print = printAge;
    }


    BiPredicate<Map.Entry<String, Integer>, Integer> finalByAge = byAge;
    people.entrySet()
            .stream()
            .filter(person -> finalByAge.test(person, limitAge))
            .forEach(print);


  }
}