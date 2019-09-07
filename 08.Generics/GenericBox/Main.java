package GenericBox;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int count = Integer.parseInt(scanner.nextLine());

    while (count > 0) {
      int number = Integer.parseInt(scanner.nextLine());

      Box<Integer> box = new Box<>(number);

      box.setElement(number);
      System.out.println(box.toString());

      count--;
    }
  }
}
