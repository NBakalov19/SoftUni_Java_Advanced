package stacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();
    ArrayDeque<String> browserHistory = new ArrayDeque<>();


    while (!line.equals("Home")) {

      if (line.equals("back")) {
        if (browserHistory.size() <= 1) {
          System.out.println("no previous URLs");
        } else {
          browserHistory.pop();
          String current = browserHistory.peek();
          System.out.println(current);
        }
      } else {
        System.out.println(line);
        browserHistory.push(line);
      }

      line = scanner.nextLine();
    }
  }
}