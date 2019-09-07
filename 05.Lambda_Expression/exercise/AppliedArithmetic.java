package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.lang.System.*;

public class AppliedArithmetic {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(in);

    int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    String commands = scanner.nextLine();

    Function<int[], int[]> add = arr ->
            Arrays.stream(arr)
                    .map(number -> ++number).toArray();
    Function<int[], int[]> multiply = arr ->
            Arrays.stream(arr)
                    .map(number -> number *= 2).toArray();
    Function<int[], int[]> subtract = arr ->
            Arrays.stream(arr)
                    .map(number -> --number).toArray();

    Consumer<int[]> printer = arr -> Arrays.stream(arr).forEach(el -> System.out.print(el + " "));

    while (!commands.equals("end")) {

      switch (commands) {
        case "add":
          numbers = add.apply(numbers);
          break;
        case "multiply":
          numbers = multiply.apply(numbers);
          break;
        case "subtract":
          numbers = subtract.apply(numbers);
          break;
        default:
          printer.accept(numbers);
          out.println();
          break;
      }
      commands = scanner.nextLine();
    }
  }
}