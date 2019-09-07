package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    Function<int[], Integer> findMinElement = arr -> {
      int minElement = Integer.MAX_VALUE;
      for (int number : arr) {
        if (number < minElement) {
          minElement = number;
        }
      }
      return minElement;
    };

    System.out.println(findMinElement.apply(numbers));
  }
}