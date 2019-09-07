package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class ReverseAndExclude {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();
    int divisor = Integer.parseInt(scanner.nextLine());

    Function<int[], int[]> divisibleNumbers = arr -> Arrays.stream(arr)
            .filter(n -> n % divisor != 0)
            .toArray();

    numbers = divisibleNumbers.apply(numbers);
    for (int i = numbers.length - 1; i >= 0; i--) {
      System.out.printf("%d ", numbers[i]);
    }
  }
}
