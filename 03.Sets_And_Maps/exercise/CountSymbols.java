package exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();

    Map<Character, Integer> occurrences = new TreeMap<>();

    for (int i = 0; i < line.length(); i++) {
      char symbol = line.charAt(i);

      if (!occurrences.containsKey(symbol)) {
        occurrences.put(symbol, 1);
      } else {
        occurrences.put(symbol, occurrences.get(symbol) + 1);
      }
    }

    occurrences.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
  }
}
