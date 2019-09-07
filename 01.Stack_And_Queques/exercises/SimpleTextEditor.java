package exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfCommands = Integer.parseInt(scanner.nextLine());

    StringBuilder text = new StringBuilder();
    ArrayDeque<StringBuilder> stack = new ArrayDeque<>();

    while (countOfCommands-- > 0) {
      String[] tokens = scanner.nextLine().split("\\s+");

      String command = tokens[0];

      switch (command) {
        case "1":
          if (text != null) {
            text.append(tokens[1]);

            stack.push(new StringBuilder(text));
          }
          break;
        case "2":
          int count = Integer.parseInt(tokens[1]);
          int start;
          if (text != null) {
            start = text.length() - count;

            text.delete(start, start + count);
          }
          if (text != null) {
            stack.push(new StringBuilder(text));
          }
          break;
        case "3":
          if (text != null) {
            System.out.println(text.charAt(Integer.parseInt(tokens[1]) - 1));
          }
          break;
        case "4":
          if (stack.size() > 1) {
            stack.pop();
            text = stack.peek();
          } else if (stack.size() == 1) {
            text = new StringBuilder();
          }
          break;
        default:
          break;
      }
    }
  }
}
