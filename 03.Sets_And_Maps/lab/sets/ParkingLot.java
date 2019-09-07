package lab.sets;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    Set<String> parkingLot = new HashSet<>();

    while (!input.equals("END")) {
      String[] commands = input.split(", ");
      String carPlate = commands[1];

      if (commands[0].equals("IN")) {
        parkingLot.add(carPlate);
      } else {
        parkingLot.remove(carPlate);
      }
      input = scanner.nextLine();
    }

    if (!parkingLot.isEmpty()) {
      parkingLot.forEach(System.out::println);
    } else {
      System.out.println("Parking Lot is Empty");
    }
  }
}
