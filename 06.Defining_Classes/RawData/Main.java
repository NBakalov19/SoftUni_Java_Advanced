package RawData;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int carsCount = Integer.parseInt(scanner.nextLine());
    List<Car> cars = new ArrayList<>();

    while (carsCount > 0) {
      String[] tokens = scanner.nextLine().split("\\s+");

      String carModel = tokens[0];
      int engineSpeed = Integer.parseInt(tokens[1]);
      int enginePower = Integer.parseInt(tokens[2]);
      int cargoWeight = Integer.parseInt(tokens[3]);
      String cargoType = tokens[4];

      ArrayList<Double> tires = new ArrayList<>();

      for (int i = 5; i < tokens.length; i += 2) {
        double tyrePressure = Double.parseDouble(tokens[i]);
        tires.add(tyrePressure);
      }

      Car car = new Car(carModel, engineSpeed, enginePower, cargoWeight, cargoType, tires);
      cars.add(car);
      carsCount--;
    }

    String searchedType = scanner.nextLine();

    if (searchedType.equals("fragile")) {
      cars.stream()
              .filter(car -> car.getCargo().getCargoTpe().equals("fragile"))
              .filter(car -> car.getTires().isValidPressure())
              .forEach(car -> System.out.println(car.getModel()));
    } else {
      cars.stream()
              .filter(car -> car.getCargo().getCargoTpe().equals("flamable"))
              .filter(car -> car.getEngine().getEnginePower() > 250)
              .forEach(car -> System.out.println(car.getModel()));
    }
  }
}