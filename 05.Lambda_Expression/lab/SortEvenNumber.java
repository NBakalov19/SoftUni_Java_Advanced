package lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] input = scanner.nextLine().split(", ");

    List<String> numbers = Arrays.stream(input)
            .map(Integer::parseInt)
            .filter(x -> x % 2 == 0)
            .map(String::valueOf)
            .collect(Collectors.toList());

    System.out.println(String.join(", ", numbers));

    numbers = numbers.stream()
            .map(Integer::parseInt)
            .sorted(Integer::compareTo)
            .map(String::valueOf)
            .collect(Collectors.toList());

    System.out.println(String.join(", ", numbers));
  }
}