package exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] command = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    int elementToOffer = command[0];
    int elementToPoll = command[1];
    int elementToFind = command[2];

    ArrayDeque<Integer> queue = new ArrayDeque<>();
    Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .limit(elementToOffer)
            .forEach(queue::offer);

    while (elementToPoll-- > 0) {
      queue.poll();
    }

    if (queue.contains(elementToFind)) {
      System.out.println("true");
    } else {
      int minElement = Integer.MAX_VALUE;
      if (queue.isEmpty()) {
        minElement = 0;
      }
      while (!queue.isEmpty()) {
        int current = queue.poll();
        if (current < minElement) {
          minElement = current;
        }
      }
      System.out.println(minElement);
    }
  }
}
