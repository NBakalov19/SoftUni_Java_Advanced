package retake.trojanInvasion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int countOfWaves = Integer.parseInt(reader.readLine());

    ArrayDeque<String> defence = new ArrayDeque<>();

    Arrays.stream(reader.readLine().split("\\s+"))
            .forEach(defence::offer);
    ArrayDeque<String> attackers = new ArrayDeque<>();

    for (int i = 1; i <= countOfWaves; i++) {
      Arrays.stream(reader.readLine().split("\\s+"))
              .forEach(attackers::push);

      if (i % 3 == 0) {
        defence.offerLast(reader.readLine());
      }

      while (!attackers.isEmpty() && !defence.isEmpty()) {
        int warrior = Integer.parseInt(attackers.pop());
        int plate = 0;
        if (defence.peekFirst() != null) {
          plate = Integer.parseInt(defence.peekFirst());
        }
        if (warrior > plate) {
          defence.poll();
          int newWarrior = warrior - plate;
          attackers.push(String.valueOf(newWarrior));
        } else if (warrior < plate) {
          int newPlate = plate - warrior;
          defence.poll();
          defence.offerFirst(String.valueOf(newPlate));
        } else {
          defence.poll();
        }
      }
      if (defence.isEmpty()) {
        break;
      }
    }


    if (!attackers.isEmpty()) {
      System.out.println("The Trojans successfully destroyed the Spartan defense.");
      System.out.print(String.format("Warriors left: %s", String.join(", ", attackers)));

    } else {
      System.out.println("The Spartans successfully repulsed the Trojan attack.");
      System.out.print(String.format("Plates left: %s", String.join(", ", defence)));

    }
  }
}