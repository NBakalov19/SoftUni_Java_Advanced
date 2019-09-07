package EqualityLogic;

import ComparingObjects.Person;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());
    TreeSet<Person> peopleByEquality = new TreeSet<>();
    HashSet<Person> peopleByHash = new HashSet<>();

    while (n > 0) {
      String[] tokens = scanner.nextLine().split("\\s+");

      Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
      peopleByEquality.add(person);
      peopleByHash.add(person);
      n--;
    }

    System.out.println(peopleByEquality.size());
    System.out.println(peopleByHash.size());

  }
}