package lab.sets;

import java.util.*;
import java.util.stream.Collectors;

public class WarGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);


    LinkedHashSet<Integer> firstPlayer = fillSet(scanner);
    LinkedHashSet<Integer> secondPlayer = fillSet(scanner);

    for (int round = 0; round < 50; round++) {
      if (firstPlayer.isEmpty()) {
        System.out.println("Second player win!");
        return;
      }
      if (secondPlayer.isEmpty()) {
        System.out.println("First player win!");
        return;
      }

      int firstPlayerCard = firstPlayer.iterator().next();
      firstPlayer.remove(firstPlayerCard);

      int secondPlayerCard = secondPlayer.iterator().next();
      secondPlayer.remove(secondPlayerCard);

      if (firstPlayerCard > secondPlayerCard) {
        firstPlayer.add(firstPlayerCard);
        firstPlayer.add(secondPlayerCard);
      } else if (secondPlayerCard > firstPlayerCard) {
        secondPlayer.add(firstPlayerCard);
        secondPlayer.add(secondPlayerCard);
      }
    }

    if (firstPlayer.size() > secondPlayer.size()) {
      System.out.println("First player win!");
    } else if (secondPlayer.size() > firstPlayer.size()) {
      System.out.println("Second player win!");
    } else {
      System.out.println("Draw!");
    }
  }

  private static LinkedHashSet<Integer> fillSet(Scanner scanner) {

    return Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
  }
}
