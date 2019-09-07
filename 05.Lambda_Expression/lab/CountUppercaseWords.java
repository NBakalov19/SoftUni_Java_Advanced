package lab;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] input = scanner.nextLine().split(" ");

    Predicate<String> isWordStartWithUppercase = word ->
            word.charAt(0) == word.toUpperCase().charAt(0);

    List<String> result = Arrays.stream(input)
            .filter(isWordStartWithUppercase)
            .collect(Collectors.toList());

    System.out.println(result.size());
    result.forEach(System.out::println);
  }
}