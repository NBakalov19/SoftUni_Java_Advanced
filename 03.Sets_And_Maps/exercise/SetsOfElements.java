package exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] sizeOfSets = scanner.nextLine().split("\\s+");

    int sizeOfFirstSet = Integer.parseInt(sizeOfSets[0]);
    Set<Integer> firstSet = fillSet(sizeOfFirstSet, scanner);

    int sizeOfSecondSet = Integer.parseInt(sizeOfSets[1]);
    Set<Integer> secondSet = fillSet(sizeOfSecondSet, scanner);

    for (Integer integer : firstSet) {
      if (secondSet.contains(integer)) {
        System.out.print(integer + " ");
      }
    }
  }

  private static Set<Integer> fillSet(int size, Scanner scanner) {
    Set<Integer> integerSet = new LinkedHashSet<>();
    String input;
    for (int i = 0; i < size; i++) {
      input = scanner.nextLine();
      integerSet.add(Integer.parseInt(input));
    }
    return integerSet;
  }
}