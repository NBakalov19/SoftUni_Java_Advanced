package lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String[] input = scanner.nextLine().split(", ");

    Function<String, Integer> parser = Integer::parseInt;

    System.out.printf("Count = %d%n", input.length);
    int sum = Arrays.stream(input)
            .map(parser)
            .reduce(0, Integer::sum);
    System.out.printf("Sum = %d", sum);
  }
}