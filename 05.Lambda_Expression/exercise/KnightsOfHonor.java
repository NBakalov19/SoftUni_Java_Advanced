package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Consumer<String> honorableNames = knight ->
            System.out.println("Sir " + knight);

    Arrays.stream(scanner.nextLine().split("\\s+"))
            .forEach(honorableNames);
  }
}