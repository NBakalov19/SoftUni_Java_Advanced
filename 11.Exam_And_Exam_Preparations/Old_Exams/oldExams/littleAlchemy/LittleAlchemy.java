package oldExams.littleAlchemy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LittleAlchemy {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ArrayDeque<Integer> table = Arrays.stream(reader.readLine().split("\\s+")).
            mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toCollection(ArrayDeque::new));

//        Arrays.stream(reader.readLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .forEach(table::offer);

    ArrayDeque<Integer> storage = new ArrayDeque<>();

    String input = reader.readLine();
    while (!input.equalsIgnoreCase("Revision")) {
      String[] commands = input.split("\\s+");
      String command = commands[0];
      if (command.equalsIgnoreCase("Apply")) {
        int dose = Integer.parseInt(commands[2]);
        while (dose > 0 && !table.isEmpty()) {
          int stone = table.peekFirst();
          stone -= 1;
          if (stone == 0) {
            storage.push(table.pollFirst());
          } else {
            int appliedStone = table.peekFirst() - 1;
            table.pollFirst();
            table.offerLast(appliedStone);
          }
          dose--;
        }
      } else {
        int reversedGold = Integer.parseInt(commands[2]);
        if (!storage.isEmpty()) {
          storage.pop();
          table.offerLast(reversedGold);
        }
      }
      input = reader.readLine();
    }

    if (!table.isEmpty()) {
      while (!table.isEmpty()) {
        System.out.print(table.pollFirst() + " ");
      }
      System.out.println();
    }

    System.out.println(storage.size());
  }
}