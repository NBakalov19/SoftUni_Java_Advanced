package CarInfo;

import java.util.Scanner;
//import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int countOfCars = Integer.parseInt(scanner.nextLine());


//        IntStream
//                .rangeClosed(1, countOfCars)
//                .boxed()
//                .map(n -> scanner.nextLine().split("\\s+"))
//                .map(data -> {
//                    Car currentCar = new Car();
//
//                    currentCar.setMake(data[0]);
//                    currentCar.setModel(data[1]);
//                    currentCar.setHorsePower(Integer.parseInt(data[2]));
//                    return currentCar;
//                })
//                .forEach(car -> System.out.println(car.getInfo()));


    for (int i = 1; i <= countOfCars; i++) {
      String[] tokens = scanner.nextLine().split("\\s+");
      String make = tokens[0];
      Car currentCar;

      if (tokens.length == 3) {
        String model = tokens[1];
        int horsePower = Integer.parseInt(tokens[2]);
        currentCar = new Car(make, model, horsePower);
      } else {
        currentCar = new Car(make);
      }

      System.out.println(currentCar.getInfo());
    }
  }
}