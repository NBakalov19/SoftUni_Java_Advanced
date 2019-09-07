package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int countOfCars = Integer.parseInt(scanner.nextLine());
    LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

    while (countOfCars > 0) {
      String[] tokens = scanner.nextLine().split("\\s+");
      String model = tokens[0];
      double fuel = Double.parseDouble(tokens[1]);
      double consumption = Double.parseDouble(tokens[2]);

      Car car = new Car(model, fuel, consumption);

      cars.putIfAbsent(model, car);
      countOfCars--;
    }

    String line = scanner.nextLine();

    while (!line.equals("End")) {
      String[] tokens = line.split("\\s+");

      String model = tokens[1];
      int distance = Integer.parseInt(tokens[2]);

      if (!cars.get(model).drive(distance)) {
        System.out.println("Insufficient fuel for the drive");
      }

      line = scanner.nextLine();
    }

    cars.values().forEach(car -> System.out.println(car.carInfo()));
  }
}