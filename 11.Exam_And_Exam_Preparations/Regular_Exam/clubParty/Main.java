package regularExam.clubParty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int hallCapacity = Integer.parseInt(reader.readLine());

    String[] tokens = reader.readLine().split("\\s+");
    ArrayDeque<String> halls = new ArrayDeque<>();
    ArrayList<Integer> currentHallReservations = new ArrayList<>();
    for (int i = tokens.length - 1; i >= 0; i--) {
      String token = tokens[i];
      if (Character.isDigit(token.charAt(0))) {
        if (halls.isEmpty()) {
          continue;
        }

        if (Integer.parseInt(token) > hallCapacity) {
          continue;
        }
        int currentReservation = Integer.parseInt(token);

        int sum = currentHallReservations.stream().mapToInt(x -> x).sum();
        if (currentReservation + sum <= hallCapacity) {
          currentHallReservations.add(currentReservation);
        } else {
          printHall(halls.poll(), currentHallReservations);
          currentHallReservations.clear();
          i++;
        }

      } else {
        halls.offer(token);
      }
    }


  }

  private static void printHall(String poll, ArrayList<Integer> currentHallReservations) {
    System.out.printf("%s -> %s%n", poll,
            currentHallReservations.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
  }
}