package ComparingObjects;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());
    TreeSet<Person> peopleByNames = new TreeSet<>(new ComparatorPeopleByNames());
    TreeSet<Person> peopleByAge = new TreeSet<>(new ComparatorPeopleByAge());

    while (n > 0) {
      String[] tokens = scanner.nextLine().split("\\s+");

      Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
      peopleByNames.add(person);
      peopleByAge.add(person);
      n--;
    }

    for (Person person : peopleByNames) {
      System.out.println(person.toString());
    }
    for (Person person : peopleByAge) {
      System.out.println(person.toString());
    }
  }
}