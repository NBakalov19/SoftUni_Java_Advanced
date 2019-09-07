package lab.maps;

import java.util.*;

public class CountRealNumbers {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double[] values = Arrays.stream(scanner.nextLine().split(" "))
            .mapToDouble(Double::parseDouble)
            .toArray();

    Map<Double, Integer> valuesWithOccurrences = new LinkedHashMap<>();

    for (double value : values) {
      if (!valuesWithOccurrences.containsKey(value)) {
        valuesWithOccurrences.put(value, 1);
      } else {
        valuesWithOccurrences.put(value, valuesWithOccurrences.get(value) + 1);
      }
    }

    for (Double key : valuesWithOccurrences.keySet()) {
      System.out.println(String.format("%.1f -> %d", key, valuesWithOccurrences.get(key)));
    }
  }
}