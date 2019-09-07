package lab.sets;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    TreeSet<String> party = new TreeSet<>();

    while (!input.equals("PARTY")) {
      party.add(input);
      input = scanner.nextLine();
    }

    while (!input.equals("END")) {
      party.remove(input);
      input = scanner.nextLine();
    }

    System.out.println(party.size());
    party.forEach(System.out::println);
  }
}