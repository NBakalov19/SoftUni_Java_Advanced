package ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    ArrayList<String> list = Arrays.stream(scanner.nextLine().split("\\s+"))
            .skip(1)
            .collect(Collectors.toCollection(ArrayList::new));

    ListIterator listIterator = new ListIterator(list);

    String command = scanner.nextLine();

    while (!command.equalsIgnoreCase("END")) {

      switch (command) {
        case "Move":
          System.out.println(listIterator.move());
          break;
        case "HasNext":
          System.out.println(listIterator.hasNext());
          break;
        case "PrintAll":
          if (list.size() > 0) {
            for (String str : listIterator) {
              System.out.print(str + " ");
            }
            System.out.println();
          }
          break;
        case "Print":
          try {
            System.out.println(listIterator.print());
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
      }
      command = scanner.nextLine();
    }
  }
}
