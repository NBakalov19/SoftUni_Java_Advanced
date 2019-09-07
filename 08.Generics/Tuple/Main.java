package Tuple;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] firstInput = scanner.nextLine().split("\\s+");
    String[] secondInput = scanner.nextLine().split("\\s+");
    String[] thirdInput = scanner.nextLine().split("\\s+");

    Threeuple<String, String, String> firstThreeuple = new Threeuple<>(
            firstInput[0] + " " + firstInput[1],
            firstInput[2],
            firstInput[3]

    );

    Threeuple<String, Integer, Boolean> secondThreeuple = new Threeuple<>(
            secondInput[0], Integer.parseInt(secondInput[1]), isDrinker(secondInput[2])

    );

    Threeuple<String, Double, String> thirdThreeuple = new Threeuple<>(
            thirdInput[0], Double.parseDouble(thirdInput[1]), thirdInput[2]
    );

    System.out.println(firstThreeuple.toString());
    System.out.println(secondThreeuple.toString());
    System.out.println(thirdThreeuple.toString());
  }

  private static boolean isDrinker(String word) {
    return word.equals("drunk");
  }
}