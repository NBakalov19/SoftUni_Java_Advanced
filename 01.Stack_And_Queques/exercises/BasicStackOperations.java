package exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int[] command = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    int elementToPush = command[0];
    int elementToPop = command[1];
    int elementToFind = command[2];

    ArrayDeque<Integer> stack = new ArrayDeque<>();
    Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .limit(elementToPush)
            .forEach(stack::push);

    while (elementToPop-- > 0) {
      stack.pop();
    }

    if (stack.contains(elementToFind)) {
      System.out.println("true");
    } else {
      int minElement = Integer.MAX_VALUE;
      if (stack.isEmpty()) {
        minElement = 0;
      }
      while (!stack.isEmpty()) {
        int current = stack.pop();
        if (current < minElement) {
          minElement = current;
        }
      }
      System.out.println(minElement);
    }
  }
}
