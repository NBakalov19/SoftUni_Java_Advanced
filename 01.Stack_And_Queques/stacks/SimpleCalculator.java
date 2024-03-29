package stacks;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] input = scanner.nextLine().split("\\s+");

    ArrayDeque<String> tokens = new ArrayDeque<>();
    Collections.addAll(tokens, input);

    while (tokens.size() > 1) {
      int firstNumber = Integer.parseInt(tokens.pop());
      String operator = tokens.pop();
      int secondNumber = Integer.parseInt(tokens.pop());
      int result = 0;

      switch (operator) {
        case "+":
          result = firstNumber + secondNumber;
          break;
        case "-":
          result = firstNumber - secondNumber;
          break;
      }
      tokens.push(String.valueOf(result));
    }
    System.out.println(tokens.peek());
  }
}
