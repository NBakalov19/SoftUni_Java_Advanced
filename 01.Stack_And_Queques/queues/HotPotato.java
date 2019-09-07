package queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] names = scanner.nextLine().split("\\s+");
    int toss = Integer.parseInt(scanner.nextLine());

    ArrayDeque<String> children = new ArrayDeque<>();
    Collections.addAll(children, names);

    while (children.size() > 1) {
      for (int i = 0; i < toss - 1; i++) {
        String currentChild = children.poll();
        if (currentChild != null) {
          children.offer(currentChild);
        }
      }
      String child = children.poll();
      System.out.println("Removed " + child);
    }

    System.out.println("Last is " + children.poll());
  }
}