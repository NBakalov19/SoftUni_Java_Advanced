package exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersOfStack {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();

//    Arrays.stream(scanner.nextLine().split("\\s+"))
//            .mapToInt(Integer::parseInt)
//            .forEach(stackOfNumbers::push);

    for (int number : numbers) {
      stackOfNumbers.push(number);
    }

    while (!stackOfNumbers.isEmpty()) {
      System.out.print(stackOfNumbers.pop() + " ");
    }
  }
}