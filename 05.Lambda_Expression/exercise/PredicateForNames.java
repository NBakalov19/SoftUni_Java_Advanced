package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int testLength = Integer.parseInt(scanner.nextLine());

    Predicate<String> checkLength = name -> name.length() <= testLength;

    Arrays.stream(scanner.nextLine().split("\\s+"))
            .filter(checkLength)
            .forEach(System.out::println);
  }
}