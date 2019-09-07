package queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();
    ArrayDeque<String> browserHistory = new ArrayDeque<>();
    ArrayDeque<String> forwards = new ArrayDeque<>();

    while (!line.equals("Home")) {

      if (line.equals("back")) {
        if (browserHistory.size() <= 1) {
          System.out.println("no previous URLs");
        } else {
          forwards.push(browserHistory.peek());
          browserHistory.pop();
          String current = browserHistory.peek();
          System.out.println(current);
        }
      } else if (line.equals("forward")) {
        if (!forwards.isEmpty()) {
          String current = forwards.pop();
          System.out.println(current);
          browserHistory.push(current);
        } else {
          System.out.println("no next URLs");
        }
      } else {
        System.out.println(line);
        browserHistory.push(line);
        if (!forwards.isEmpty()) {
          forwards.clear();
        }
      }
      line = scanner.nextLine();
    }
  }
}