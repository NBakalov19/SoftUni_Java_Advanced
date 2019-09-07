package CarSalesmen;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfEngines = Integer.parseInt(scanner.nextLine());
    Map<String, Engine> engines = new HashMap<>();
    Engine engine;

    while (countOfEngines > 0) {
      String[] tokens = scanner.nextLine().split("\\s+");
      String engineModel = tokens[0];
      int enginePower = Integer.parseInt(tokens[1]);
      if (tokens.length == 2) {
        engine = new Engine(engineModel, enginePower);
      } else if (tokens.length == 3) {
        engine = new Engine(engineModel, enginePower, tokens[2]);
      } else {
        String displacement = tokens[2];
        String efficiency = tokens[3];
        engine = new Engine(engineModel, enginePower, displacement, efficiency);
      }
      engines.put(engineModel, engine);
      countOfEngines--;
    }

    int carsCount = Integer.parseInt(scanner.nextLine());
    List<Car> cars = new ArrayList<>();
    Car car;
    while (carsCount > 0) {
      String[] tokens = scanner.nextLine().split("\\s+");
      String carModel = tokens[0];
      String carEngine = tokens[1];
      engine = engines.get(carEngine);

      if (tokens.length == 2) {
        car = new Car(carModel, engine);
      } else if (tokens.length == 3) {
        car = new Car(carModel, engine, tokens[2]);
      } else {
        String weight = tokens[2];
        String color = tokens[3];
        car = new Car(carModel, engine, weight, color);
      }
      cars.add(car);
      carsCount--;
    }

    cars.forEach(c -> System.out.println(c.carInfo()));
  }
}