package queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {

  private static boolean isPrime(int number) {
    if (number == 1) {
      return false;
    }
    for (int i = 2; i < number; i++) {
      if (number % 2 == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] names = scanner.nextLine().split("\\s+");
    int toss = Integer.parseInt(scanner.nextLine());
    ArrayDeque<String> children = new ArrayDeque<>();
    Collections.addAll(children, names);

    int cycle = 1;

    while (children.size() > 1) {
      for (int i = 0; i < toss - 1; i++) {
        String currentChild = children.poll();
        children.offer(currentChild);
      }
      if (isPrime(cycle)) {
        String child = children.peek();
        System.out.println("Prime " + child);
      } else {
        String child = children.poll();
        System.out.println("Removed " + child);
      }
      cycle++;
    }
    System.out.println("Last is " + children.poll());
  }
}