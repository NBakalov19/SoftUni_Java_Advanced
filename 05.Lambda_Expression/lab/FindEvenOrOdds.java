package lab;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvenOrOdds {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] range = scanner.nextLine().split("\\s+");
    String type = scanner.nextLine();

    int start = Integer.parseInt(range[0]);
    int end = Integer.parseInt(range[1]);

    Predicate<Integer> filterEvens = x -> x % 2 == 0;
    Predicate<Integer> filterOdds = x -> x % 2 != 0;

    Predicate<Integer> byType = filterEvens;

    if (type.equals("odd")) {
      byType = filterOdds;
    }

    IntStream.rangeClosed(start, end)
            .boxed()
            .filter(byType)
            .forEach(n -> System.out.printf("%d ", n));
  }
}
