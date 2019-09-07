package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int number = Integer.parseInt(scanner.nextLine());
    int[] divisorsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    Set<Integer> divisors = Arrays.stream(divisorsArr)
            .boxed()
            .collect(Collectors.toSet());

    BiPredicate<Set<Integer>, Integer> isDivisible = (set, num) -> {
      boolean isTrue = true;
      for (Integer divisor : set) {
        if (num % divisor != 0) {
          isTrue = false;
          break;
        }
      }
      return isTrue;
    };

    for (int i = 1; i <= number; i++) {
      if (isDivisible.test(divisors, i)) {
        System.out.print(i + " ");
      }
    }
  }
}