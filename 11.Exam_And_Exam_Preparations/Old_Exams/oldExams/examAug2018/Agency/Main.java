package oldExams.examAug2018.Agency;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    ArrayDeque<String> idNumbers = new ArrayDeque<>();
    ArrayDeque<String> agents = new ArrayDeque<>();

    String[] input = scanner.nextLine().split("\\s+");

    for (String s : input) {
      idNumbers.push(s);
    }

    input = scanner.nextLine().split("\\s+");

    for (String s : input) {
      agents.offer(s);
    }

    String[] tokens = scanner.nextLine().split("\\s+");

    while (!tokens[0].equals("stop")) {

      String command = tokens[0];

      switch (command) {
        case "add-ID":
          String newId = tokens[1];
          idNumbers.push(newId);
          break;
        case "add-agent":
          String newAgent = tokens[1];
          agents.offerLast(newAgent);
          break;
        case "remove-ID":
          String removedId = idNumbers.poll();
          System.out.printf("%s has been removed.%n", removedId);
          break;
        case "remove-agent":
          String removedAgent = agents.pollLast();
          System.out.printf("%s has left the queue.%n", removedAgent);
          break;
        default:
          idNumbers = idNumbers.stream()
                  .sorted(Comparator.reverseOrder())
                  .collect(Collectors.toCollection(ArrayDeque::new));
          break;
      }
      tokens = scanner.nextLine().split("\\s+");
    }

    while (idNumbers.size() > 0 && agents.size() > 0) {
      String idNumber = idNumbers.pop();
      String agent = agents.poll();
      System.out.println(String.format("%s takes ID number: %s", agent, idNumber));
    }

    if (!idNumbers.isEmpty()) {
      System.out.println("No more agents left.");
      while (idNumbers.size() > 0) {
        System.out.printf("ID number: %s%n", idNumbers.pop());
      }
    } else if (!agents.isEmpty()) {
      while (agents.size() > 0) {
        System.out.printf("%s does not have an ID.%n", agents.poll());
      }
    }
  }
}