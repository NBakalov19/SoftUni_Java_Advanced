package exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfCommands = Integer.parseInt(scanner.nextLine());

    ArrayDeque<Integer> stack = new ArrayDeque<>();
    String[] commands;
    for (int i = 0; i < countOfCommands; i++) {
      commands = scanner.nextLine().split("\\s+");

      if (commands[0].equals("1")) {
        stack.push(Integer.parseInt(commands[1]));
      } else if (commands[0].equals("2")) {
        stack.pop();
      } else {
//          ArrayDeque<Integer> stackCopy = stack.clone();
//          int max = Integer.MIN_VALUE;
//
//          while (!stackCopy.isEmpty()) {
//              max = Math.max(stackCopy.pop(), max);
//          }
        int max = Collections.max(stack);
        System.out.println(max);
      }
    }
  }
}