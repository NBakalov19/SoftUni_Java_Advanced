package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<Integer> sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    Function<List<Integer>, Integer> getIndexOfSmallestElement = list -> {
      int minElement = Integer.MAX_VALUE;

      for (int i = list.size() - 1; i >= 0; i--) {
        if (list.get(i) < minElement) {
          minElement = list.get(i);
        }
      }
      return list.lastIndexOf(minElement);
    };

    System.out.println(getIndexOfSmallestElement.apply(sequence));
  }
}
