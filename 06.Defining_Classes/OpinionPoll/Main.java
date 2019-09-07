package OpinionPoll;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int countOfPersons = Integer.parseInt(scanner.nextLine());

    IntStream
            .rangeClosed(1, countOfPersons)
            .boxed()
            .map(p -> scanner.nextLine().split("\\s+"))
            .map(data -> {
              Person person = new Person();

              person.setName(data[0]);
              person.setAge(Integer.parseInt(data[1]));
              return person;
            })
            .filter(person -> person.getAge() > 30)
            .sorted(Comparator.comparing(Person::getName))
            .forEach(person -> System.out.println(person.print()));
  }
}