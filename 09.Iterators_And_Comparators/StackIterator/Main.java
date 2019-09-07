package StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    StackIter<Integer> stack = new StackIter<>();

    String input = scanner.nextLine();

    while (!input.equals("END")) {
      if (input.contains("Push")) {
        Arrays.stream(input.split("([, ]+)"))
                .skip(1)
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);
      } else {
        try {
          stack.pop();
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }

      input = scanner.nextLine();
    }

    for (Integer integer : stack) {
      System.out.println(integer);
    }

    for (Integer integer : stack) {
      System.out.println(integer);
    }
  }
}