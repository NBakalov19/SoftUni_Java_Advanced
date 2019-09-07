package exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();
    ArrayDeque<Character> parentheses = new ArrayDeque<>();

    for (int i = 0; i < input.length(); i++) {
      char current = input.charAt(i);

      if (current == '{' || current == '[' || current == '(') {
        parentheses.push(current);
      } else {
        if (parentheses.isEmpty()) {
          System.out.println("NO");
          return;
        }
        char opening = parentheses.pop();
        if (current == '}' && opening != '{') {
          System.out.println("NO");
          return;
        } else if (current == ']' && opening != '[') {
          System.out.println("NO");
          return;
        } else if (current == ')' && opening != '(') {
          System.out.println("NO");
          return;
        }
      }
    }
    System.out.println("YES");
  }
}