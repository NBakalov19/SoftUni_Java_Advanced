package exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();
    LinkedHashMap<String, String> emails = new LinkedHashMap<>();
    String name = "";
    int counter = 0;
    while (!input.equals("stop")) {

      if (counter % 2 == 0) {
        name = input;
        emails.put(name, "");
      } else {
        String[] tokens = input.split("\\.");
        String domain = tokens[tokens.length - 1];
        if (domain.equals("bg")) {
          emails.put(name, input);
        } else {
          emails.remove(name);
        }
      }
      counter++;
      input = scanner.nextLine();
    }

    emails.forEach((key, value) ->
            System.out.println(String.format("%s -> %s", key, value)));
  }
}
