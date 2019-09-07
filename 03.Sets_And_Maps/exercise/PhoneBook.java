package exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class PhoneBook {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    LinkedHashMap<String, String> phoneBook = new LinkedHashMap<>();

    while (!input.equals("search")) {
      String[] tokens = input.split("-");
      String name = tokens[0];
      String number = tokens[1];

      phoneBook.putIfAbsent(name, number);
      phoneBook.put(name, number);
      input = scanner.nextLine();
    }
    input = scanner.nextLine();
    while (!input.equals("stop")) {
      if (phoneBook.containsKey(input)) {
        System.out.println(String.format("%s -> %s", input, phoneBook.get(input)));
      } else {
        System.out.printf("Contact %s does not exist.\n", input);
      }
      input = scanner.nextLine();
    }
  }
}
